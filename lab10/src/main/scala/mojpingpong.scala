import akka.actor.{ActorSystem, Actor, Props, ActorRef}

object Gracz1{
    case class Start(oponent: ActorRef)
    case object Ping
    case object Pong
}

class Gracz1 extends Actor{
    import Gracz1._
    def receive: Receive = {
        case Start(oponent) => oponent ! Ping
        case Ping =>
            println("doszedł Ping") 
            sender() ! Pong
        case Pong =>
            println("doszedł Pong") 
            sender() ! Ping
    }
}

object Main extends App {
    val system = ActorSystem("mySystem")
    val janusz = system.actorOf(Props[Gracz1], "janusz")
    val pawlacz = system.actorOf(Props[Gracz1], "pawlacz")

    janusz ! Gracz1.Start(pawlacz)
}