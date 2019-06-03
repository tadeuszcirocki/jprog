object Zad16 extends App {

  def compute[A,B](seq: Seq[A])(init: B)(op: (A, B) => B): B = {
    // Korzystając z wartości początkowej „init” oraz funkcji op
    // oblicz „wartość” ciągu „seq”. Przykładowo:
    // compute(Seq(1,2,3,4))(0)(_ + _) == 10
    // compute(Seq(1,2,3,4))(1)(_ * _) == 24
    // compute(Seq("kota"," ","ma"," ","ala"))("")(_ + _) == "ala ma kota"
    def helper()
  }

}
