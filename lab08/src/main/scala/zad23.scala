object zad23 extends App{

    def indices[A](seq: Seq[A], el: A): Set[Int] = {
        val (res, _) = seq.foldLeft( (Set[Int](),0) ) { (acc, elem) => acc match{
            case(s, n) =>
                if(elem == el) (s+n, n+1)
                else (s, n+1)
        }
        }
        res
    }

    println(indices(Seq(1,2,1,1,5), 1))
}