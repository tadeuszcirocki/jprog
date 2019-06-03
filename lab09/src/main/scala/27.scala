object zad27 extends App {
    import scala.io.Source
    val linie = Source.fromFile("liczby.txt").getLines.toList

    def isCiagNiemalejacy(number: String): Boolean = {
        val x = number.zip(number.tail)
        x.forall({
            case (a,b) => a >= b
        })
    }

    def isSumOdd(number: String): Boolean = {
        val sum = number.foldLeft(0)(_ + _)
        sum % 2 == 0
    } 
    
    def filterNumbers(numbers: Seq[String]):Seq[String] = {
        numbers.filter(a => isSumOdd(a)==true && isCiagNiemalejacy(a)==true)
    }
    println(filterNumbers(linie))
}