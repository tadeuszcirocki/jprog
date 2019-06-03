object Zad14 extends App {

  def deStutter[A](seq: Seq[A]): Seq[A] = {
    // W ciągu „seq” zastąp wszystkie podciągi składające się
    // z powtarzanego elementu jego pojedynczą kopią. Oznacza to,
    // że np. deStutter(Seq(1,3,3,3,1,1,4)) == Seq(1,3,1,4).
    def helper(inp: Seq[A], out: Seq[A]): Seq[A] = (inp, out) match {
      case (Seq(), _) => out //Seq() to pusty ciag
      case (pierwszy +: reszta, Seq()) => helper(reszta, Seq(pierwszy)) //sekwencja jednoelementowa
      case (pierwszy +: reszta, el +: ogon) if pierwszy == el => helper(reszta, out)
      case (pierwszy +: reszta, el +: ogon) => helper (reszta, pierwszy +: out)
    }
    helper(seq, Seq()).reverse
  }

}
