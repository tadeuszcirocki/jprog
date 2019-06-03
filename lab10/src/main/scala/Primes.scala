import akka.actor.{Actor, ActorRef, ActorSystem, Props, Stash}
/*
 * Poniższy program działa poprawnie jedynie „jednorazowo” – jeśli
 * do „szefa” prześlemy koleje zadania (patrz – program główny) to
 * niestety nie otrzymamy na nie odpowiedzi.
 *
 * Powodem jest to, że po otrzymaniu (pierwszego) zadania i przejściu
 * do roli „czekamyNaWynik” komunikaty inne niż Wynik nie są obsługiwane
 * i trafiają do „biura listów zagubionych”.
 *
 * Jednym z możliwych rozwiązań jest „odkładanie” kolejnych wiadomości
 * typu Zadanie do wykonania później – po zakończeniu obsługi aktualnego
 * zadania. Możemy to zrobić korzystając z operacji:
 *
 *   - stash() oraz unstashAll()
 *
 * pochodzących z cechy Stash, której dokumentację można znaleźć na stronie:
 *
 *   – https://doc.akka.io/docs/akka/current/actors.html?language=scala
 *
 * Kiedy już poradzimy sobie z problemem gubienia zadań, okaże się, że jedynie
 * zadanie „Zadanie(127)”, a następnie „Zadanie(256)” zwrócą poprawne wyniki.
 * Dla „Zadanie(25)” wynik będzie identyczny jak dla „Zadanie(256)”.
 *
 * Powód jest jasny – hierarchia aktorów akumulujących liczby pierwsze rośnie
 * (w miarę pojawiania się zadań o większym zakresie), ale reakcja na komunikat
 * WynikProszę nie bieże tego pod uwagę.
 *
 * Zastanów się jak temu zaradzić. Postaraj się, żeby ostateczne rozwiązanie
 * było maksymalnie czytelne i nadal nie używało zmiennych ;)
 */
// 
case class Zadanie(n: Int)
case class Komunikat(n: Int)
case object WynikProszę
case class Wynik(pierwsze: Seq[Int])

class Szef extends Actor with Stash{

  def receive = czekamyNaZadanie

  def czekamyNaZadanie: Receive = {
    case Zadanie(n) =>
      val pracownik = context.actorOf(Props[Pracownik], "pracownik")
      for (k <- 2 to n) {
        pracownik ! Komunikat(k)
      }
        
      pracownik ! WynikProszę
      context.become(czekamyNaWynik)
  }

  def czekamyNaWynik: Receive = {
    case Wynik(pierwsze) =>
      println(s"liczby pierwsze: $pierwsze")
      unstashAll()
     // context.become(maPracownika)
    case msg => stash()
  }

  // def maPracownika: Receive = {
  //     case Zadanie(n) =>
  //       for(k <- 2 to n){
  //           pracownik ! Komunikat(n)
  //       }
  //       pracownik ! WynikProszę
  //     context.become(czekamyNaWynik)
  // }

}

class Pracownik extends Actor {

  def receive: Receive = { //pierwsze co sie dzieje po otrzymaniu wiadomosci
    case Komunikat(n) =>
      context.become(zeSkarbem(n)) //zmieniamy tozsamosc aktora na innego defa, lecimy dalej
  }

  def zeSkarbem(skarb: Int): Receive = {
    case msg @ Komunikat(n) if n % skarb != 0 => //msg==Komunikat(n)
      val podwykonawca = context.actorOf(Props[Pracownik], s"skarb$skarb")
      podwykonawca ! msg
      context.become(zeSkarbemIPotomkiem(skarb, podwykonawca))
    case WynikProszę =>
      context.parent ! Wynik(Seq(skarb))
  }

  def zeSkarbemIPotomkiem(skarb: Int, potomek: ActorRef): Receive = {
    case msg @ Komunikat(n) if n % skarb != 0 =>
      potomek ! msg
    case msg @ WynikProszę =>
      potomek ! msg
      context.become(czekającNaWynik(skarb))
  }

  def czekającNaWynik(skarb: Int): Receive = {
    case Wynik(liczby) =>
      context.parent ! Wynik(skarb +: liczby)
  }

}

object Primes extends App {
  // wszystko tutaj jest zawartością „metody main”
  val system = ActorSystem("NaszSystem")
  // powołujemy do życia ktora „globalnego”
  val szef = system.actorOf(Props[Szef], "szef")
  szef ! Zadanie(127)
  szef ! Zadanie(256)
  szef ! Zadanie(25)
}

// DYGRESJE

// val futN: Future[Int]
// val futM: Future[Int]
//
// val wynik = (for {
//   n <- futN
//   m <- futM
// } yield n + m): Future[Int]
//
// import akka.pattern.ask
// import akka.util.Timeout
// import scala.concurrent.duration._
//
// implicit val timeout = Timeout(5 seconds)
// val future = (pracownik ? WynikProszę) : Future[Any]