object apply extends App {


    def applyForAll[A,B](seq: Seq[A], f: A => B): Seq[B] = {
        @annotation.tailrec
        def helper(inp: Seq[A], out: Seq[B]): Seq[B] = inp match { //nie ma sesnu dawac znowu funkcje do parametrow
            case Seq() => out
            case głowa +: ogon => helper(ogon, f(głowa) +: out)
        }
        helper(seq, Seq()).reverse
    }
}