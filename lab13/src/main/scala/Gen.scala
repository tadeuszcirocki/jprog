package jp.lab13

sealed trait Płeć
case object M extends Płeć
case object K extends Płeć

object Gen {
  import scala.io.Source
  import scala.util.Random
  private val rand = new Random
  val imiona = Source.fromResource("imiona-meskie.csv").getLines.toList.map(n => n.takeWhile(_ != ','))
  val nazwiska = Source.fromResource("nazwiska-meskie.csv").getLines.toList.map(n => n.takeWhile(_ != ','))
  
  def osoba: Osoba ={
    val imie = imiona(rand.nextInt(21000))
  val nazwisko = imiona(rand.nextInt(21000))
    val os = new Osoba(imie,nazwisko)
    
    os
  }
  def osoba(płeć: Płeć): Osoba = {
    rand.nextInt(1) == 0 ? osoba(M) : osoba(K)
  }
  def ocena: Ocena = {
    val oc = new Ocena(rand.nextInt(10),rand.nextInt(10),rand.nextInt(10))
    oc
  }
}
