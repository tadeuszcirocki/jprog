object Zad12 extends App {

  def isOrdered[A](seq: Seq[A])(leq: (A,A) => Boolean): Boolean = {
    // Sprawdź czy ciąg „seq” jest uporządkowany zgodnie z „leq”.
    // leq(a1,a2) oznacza, że „a1 jest mniejsze lub równe a2”


    def helper[A](seq: Seq[A])(leq: (A,A) => Boolean): Boolean = seq match {
      case Seq() => true
      case a +: b+: reszta if(!leq(a,b)) => false
      case pier +: reszta => helper(reszta)(leq)
    }
    helper(seq)(leq)
  }

}
















//if(seq.isEmpty) true
  //  else if(seq.length == 1) true
   // else if(!leq(seq.head,(seq.tail).head)){
  //    false
  //  }
  //  else{
   //   isOrdered(seq.tail)(leq)
   // }







