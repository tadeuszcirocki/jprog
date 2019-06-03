package jp.aktorzy

import akka.actor.{ActorSystem, Actor, Props}

class MyActor extends Actor {
  def receive: Receive = {
    case x: Int =>
      println("Bueeeeee")
      context.stop(self)
    case x => println(s"dostałem „$x”")
  }
}

object Main extends App {

  val system = ActorSystem("sys")

  val jasio = system.actorOf(Props[MyActor], "jasio")
  val kasia = system.actorOf(Props[MyActor], "kasia")

  jasio ! "aqq"
  kasia ! 123

  // system.terminate()

}
