object zad28 extends App{
    import scala.io.Source
    val linie = Source.fromFile("nazwiska.txt").getLines.toList
    //def isMaxDifferentLetters(linia: String, max: Int): Boolean = ???
    //def isMinDiffLetters(linia: String, min: Int): Boolean = ???
    def getImie(linia: String): String = {
        linia.takeWhile(a => !(a.equals(' ')))
    }
    def getNazwisko(linia: String): String = {
        linia.reverse.takeWhile(a => a != ' ').reverse
    }
    //def filterNazwiska(linie: Seq[String]): Seq[String] = 
    def max(a: String, b: String): String =
        if (a.toSet.size > b.toSet.size) a else b    
    val maxIloscRoznychLiter = linie.map(a => getImie(a)).reduceLeft(max)
    println(maxIloscRoznychLiter)
}