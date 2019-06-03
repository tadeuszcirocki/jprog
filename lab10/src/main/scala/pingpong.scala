// import akka.actor.{Actor, ActorRef, ActorSystem, Props}

// object Gracz {
//     case object Ping
//     case object Pong
//     case class Start(przeciwnik: ActorRef)
// }

// //class Gracz extends Actor {
//   //  import Gracz._

//     def receive: Receive = {
//         case Start(oponent) => oponent ! Ping
//         case Ping =>
//             println(s"${self.path}: doszedl Ping")
//             sender() ! Pong
//         case Pong =>
//             println(s"${self.path}: doszedl Pong")
//             sender() ! Ping
//         case msg => println(s"dostalem $msg")
//     }
// }

// //object PingPong extends App {
//   //  val system = ActorSystem("Gra")

//   //  val tomek = system.actorOf(Props[Gracz], "tomek")
//    // val kasia = system.actorOf(Props[Gracz], "kasia")

//     //kasia ! Gracz.Start(tomek)
// //}