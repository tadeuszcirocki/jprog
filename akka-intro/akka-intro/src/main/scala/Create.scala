package jp.aktorzy.tworzenie

import akka.actor.{ActorSystem, Actor, ActorRef, Props}

object MyActor {
  case object Status
  case class DoIt(n: Int)
}

class MyActor extends Actor {
  import MyActor._

  def receive: Receive = {
    case DoIt(x) =>
      println(s"${self.path}: dostałem „$x”")
      val pracownik = context.actorOf(Props[Worker], s"gucio0")
      pracownik ! Worker.Work(x)
      // zmieniamy tożsamość
      context.become(withWorkers(Set(pracownik)))
  }

  def withWorkers(gs: Set[ActorRef]): Receive = {
    case DoIt(x) =>
      println(s"${self.path}: dostałem „$x”")
      val pracownik = context.actorOf(Props[Worker], s"gucio${gs.size}")
      pracownik ! Worker.Work(x)
      context.become(withWorkers(gs + pracownik))
  }

}

object Worker {
  case class Work(n: Int)
}

class Worker extends Actor {
  // importujemy komunikaty
  import Worker._

  def receive = {
    case Work(x) => println(s"${self.path}: mam wykonać: „$x”")
  }
}

object Main extends App {

  val system = ActorSystem("sys")

  val szef = system.actorOf(Props[MyActor], "szef")

  import MyActor._
  szef ! DoIt(5)
  szef ! DoIt(5)
  szef ! DoIt(7)
  szef ! DoIt(7)

  // system.terminate()
}
