object zad19 extends App{
    def subseq[A](seq: Seq[A], bIdx: Int, eIdx: Int): Seq[A] = {
        seq.take(eIdx).drop(bIdx)
    }
    subseq(Seq(1,2,3,4,5),2,3)
}