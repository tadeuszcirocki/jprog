package jp.aktorzy.monitoring

import akka.actor.{ActorSystem, Actor, ActorRef, Props, Terminated, ActorLogging, PoisonPill}

object Szef {
  case object Status
  case class DoIt(n: Int)
  case class Result(s: String)
}

class Szef extends Actor with ActorLogging {
  import Szef._

  import collection.mutable.{Set => MSet}
  val wynik: MSet[String] = MSet()

  def receive: Receive = {
    case DoIt(x) =>
      log.info(s"\ndostałem „$x”")
      val pracownik = context.actorOf(Props[Worker], s"gucio0")
      context.watch(pracownik)
      pracownik ! Worker.Work(x)
      // zmieniamy tożsamość
      context.become(withWorkers(Set(pracownik)))
  }

  def withWorkers(gs: Set[ActorRef]): Receive = {
    case DoIt(x) =>
      log.info(s"\ndostałem „$x”")
      val pracownik = context.actorOf(Props[Worker], s"gucio${gs.size}")
      context.watch(pracownik)
      pracownik ! Worker.Work(x)
      context.become(withWorkers(gs + pracownik))
    case Result(s) =>
      log.info(s"\ndostałem wynik „$s”")
      wynik += s
    case Terminated(gucio) =>
      log.info(s"$gucio się sterminował biedaczek :(")
      val pracownicy = gs - gucio
      if (pracownicy.isEmpty) {
        log.info(s"wynik to: $wynik")
        context.system.terminate()
      }
      context.become(withWorkers(pracownicy))
  }

}

object Worker {
  case class Work(n: Int)
}

class Worker extends Actor with ActorLogging {
  // importujemy komunikaty
  import Worker._

  def receive = {
    case Work(x) =>
      log.info(s"\nmam wykonać: „$x”")
      val res = self.path.toString.split("/").last
      val sufiks = "*" * x
      sender() ! Szef.Result(s"$res-$sufiks")
      context.stop(self)
  }
}

object Main extends App {

  val system = ActorSystem("sys")

  val szef = system.actorOf(Props[Szef], "szef")

  szef ! Szef.DoIt(5)
  szef ! Szef.DoIt(5)
  szef ! Szef.DoIt(7)
  szef ! Szef.DoIt(7)
  // szef ! PoisonPill
  // system.terminate()
}
