object zad24 extends App{

    def swap[A](seq: Seq[A]): Seq[A] = {
        seq
            .sliding(2,2) //iterator czyli coś z next
            .toList
            .map(_.reverse)
            .flatten
    }
    println(swap(Seq(1,2,3,4,5)))
}