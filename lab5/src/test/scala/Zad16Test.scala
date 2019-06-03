import org.scalatest._

class Zad16Test extends FlatSpec with Matchers {

  "compute" should "properly handle empty sequence" in {
    Zad16.compute(Seq[Int]())(0)(_ + _) shouldBe 0
  }
  it should "properly sum a nonempty Int sequence" in {
    Zad16.compute(Seq(1,2,3,4))(0)(_ + _) shouldBe 10
  }
  it should "concatenate a nonempty String sequence in reverse order" in {
    Zad16.compute(Seq("kota"," ","ma"," ","ala"))("")(_ + _) shouldBe "ala ma kota"
  }
  it should "return a combined length of all elements of a String sequence" in {
    Zad16.compute(Seq("kota"," ","ma"," ","ala"))(0)( (s: String, n: Int) => s.length + n) shouldBe 11
  }

}
