object zad1 extends App{

    def merge[A](a: Seq[A], b: Seq[A])
    (leq: (A,A) => Boolean): Seq[A] = {
        @annotation.tailrec
        def helper(a1: Seq[A], b1: Seq[A], acc: Seq[A]) //Seq - slowo kluczowe dla sekwencji. np ciagu
        : Seq[A] = {
            (a1,b1) match {
            case _ if (a1.isEmpty || b1.isEmpty) =>
            acc.reverse ++ a1 ++ b1 //konkatenacja ciagu
            case (a1Head +: a1Tail, b1Head +: b1Tail) => //a1Head - nazwa lokalna
                if(leq(a1Head,b1Head)){
                    helper(a1Tail, b1, a1Head +: acc)
                } else{
                    helper(a1, b1Tail, b1Head +: acc)
                }
        }

        }

        helper(a, b, Seq.empty)

        
    }
// porownuje kolejne elementy, np 1wszy z 1wszym, nie sortuje
    val s1 = Seq(1,2,3,4,5)
    val s2 = Seq(2,3,4)
    println(merge(s1,s2)((m,n) => m < n))

}