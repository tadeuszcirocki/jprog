object Zad13 extends App {

  def insertInto[A](el: A, seq: Seq[A])(leq: (A,A) => Boolean): Seq[A] = {
    // Wstaw element „a” do ciągu „seq” zgodnie z porządkiem określonym
    // przez „leq”.
    def helper[A](el: A, seq: Seq[A])(leq: (A,A) => Boolean): Seq[A] = seq match {
      case Seq() => seq :+ el
      case a +: reszta if(leq (a,reszta.head)) => helper(el,reszta)(leq) 
      case a +: reszta => reszta :+ el
    }
    helper(el,seq)(leq)
  }

}
