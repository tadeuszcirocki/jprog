object zad29 extends App {

    def histogram(maks: Int): Unit = {

        import scala.io.Source
        val tekst = Source.fromFile("ogniem-i-mieczem.txt")
        tekst
           .collect{ case c if c.isLetter => c.toLower }
           .groupBy(identity)
           .mapValues(l => "*" * l.length)
    }

}
