import org.scalatest._

class Zad15Test extends FlatSpec with Matchers {

  "compress" should "properly handle empty sequence" in {
    Zad15.compress(Seq()) shouldBe Seq()
  }
  it should "properly handle one-element sequences" in {
    Zad15.compress(Seq('x')) shouldBe Seq(('x',1))
  }
  it should "properly handle sequences containing single repeated element" in {
    Zad15.compress(Seq(2,2,2,2)) shouldBe Seq((2,4))
  }
  it should "properly handle sequences containing two nonempty subsequences" in {
    Zad15.compress(Seq(2,2,2,5)) shouldBe Seq((2,3), (5,1))
  }
  it should "properly handle sequences containing more than two nonempty subsequences" in {
    Zad15.compress(Seq(2,2,2,5,2,2)) shouldBe Seq((2,3), (5,1), (2,2))
  }

}
