// import akka.actor.{ActorSystem, Actor, ActorRef, Props}

// class MyActor extends Actor {
//   def receive: Receive = {  //zwraca typ Receive
//     case msg => println(s"Odebrałem wiadomość: $msg")
//   }
// }
// object Nadzorca {
//   case class Init(liczbaPracowników: Int)
//   case class Zlecenie(dane: List[String])
// }
// class Nadzorca extends Actor { //nadzorca tworzy pracownikow, definicja aktora
//   import Nadzorca._

//   def przedInit: Receive = {
//     case Init(n) => val pracownicy = (1 to n).toList.map(n => context.actorOf(Props[MyActor], n))
//     //tworzymy n pracownikow
//     context.become(poInit(pracownicy))
//   }
//   def poInit(pracownicy: List[ActorRef]): Receive = {

//   }
//   def receive: Receive = przedInit
// }

// object Main extends App {
//   def dane(): List[String] = {
//     scala.io.Source.fromResource("ogniem-i-mieczem.txt").getLines.toList
//   }
//     val system = ActorSystem("HaloAkka") //system aktorow, bez niego aktorzy nie moga zyc
//     val leonardo = system.actorOf(Props[MyActor], "leonardo") //tworzenie aktora
//     leonardo ! "Dostałeś Oskara!"
//     leonardo ! 231

//     println(dane())

// }





//reStart zeby odpalic

//aktorzy to nie zwykle obiekty, potrzebuja systemu aktorow zeby
//dzialac, dlatego tworzy ich sie w specyficzny sposob