object Main extends App {
  def jestPierwsza(n:Int): Boolean = {
    @annotation.tailrec
    def jestPierwszaOgonowa(n:Int, divisor: Int = 2):Boolean = {
      if (divisor > Math.sqrt(n)) true
      else if(n%divisor==0) false
      else jestPierwszaOgonowa(n,divisor+1)
      
    }
    if (n<2) false else jestPierwszaOgonowa(n)
  }
  println(jestPierwsza(11))
 
}

//l pierwsza dzieli sie przez siebie i 1
//new file i odswiezyc jak chce nowe zadanko