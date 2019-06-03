import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object Gracz {
    case object Ping
    case object Pong
    case class Start(przeciwnik: ActorRef)
    case object Start
}

class Gracz extends Actor {
    import Gracz._

    def receive: Receive = {
        case Start(oponent) =>
            oponent ! Start 
            oponent ! Ping
            context.become(poStart)
        case Start =>
            context.become(poStart)
    }

    def poStart: Receive = {
        case Ping =>
            println(s"${self.path}: doszedl Ping")
            sender() ! Pong
        case Pong =>
            println(s"${self.path}: doszedl Pong")
            sender() ! Ping
    }
}

object PingPongv2 extends App {
    val system = ActorSystem("Gra")

    val tomek = system.actorOf(Props[Gracz], "tomek")
    val kasia = system.actorOf(Props[Gracz], "kasia")

    kasia ! Gracz.Start(tomek)
}