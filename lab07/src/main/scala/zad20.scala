object zad20 extends App{

    def deStutter[A](seq: Seq[A]): Seq[A] = {
        val (_. ciag) = seq.foldLeft(( None: Option[Int], Seq[Int]()) )( (acc: (Option[Int], Seq[Int]) )  => { //moze byc prostsze rozwiazanie bez option. taki poczatek zeby wyciagnac drugi element z pary
            acc._1 match {
                case None => ( Some(el), Seq(el) )
                case Some(n) if el != n => ( Some(el), el +: acc._2)
                case _ => acc
            }
        })
        ciag.reverse        
    }

} //foldLeft zastepuje nam petle przez elementy sekwencji