object Zad15 extends App {

  def compress[A](seq: Seq[A]): Seq[(A, Int)] = {
    // w ciągu „seq” zastąp każdy podciąg powtarzających
    // się elementów „a...a” parą „(a, <długość podciągu>)”
    // np. compress(Seq('a','a','b','c','c','c','d','d','c'))
    // == Seq( ('a',2), ('b',1), ('c',3), ('d',2), ('c',1) )
    
    def helper(inp: Seq[A], out: Seq[(A, Int)]): Seq[A, Int] = (inp, out) match { //uzywamy matcha bo to nie C
        case (Seq(),_) => out  //pusty ciag i cokolwiek. rozwazamy rozne przypadki
        case (głowa +: ogon, Seq()) => Seq(()) 
    }
  }

}
//Seq(1,2,3)
//Seq(('a',2), ('b',1), ('c',3)) ciag 3 elementowy
