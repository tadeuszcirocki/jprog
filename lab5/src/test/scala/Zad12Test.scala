import org.scalatest._

class Zad12Test extends FlatSpec with Matchers {
  "isOrdered" should "be true for empty sequence" in {
    Zad12.isOrdered(Seq[Int]())(_ < _) shouldBe true
  }
  it should "be true for one-element sequences" in {
    Zad12.isOrdered(Seq('a'))(_ < _) shouldBe true
  }
  it should "be true for ordered numeric sequences" in {
    Zad12.isOrdered(Seq(1,2,4,6,7))(_ < _) shouldBe true
  }
  it should "be true for ordered sequences of Strings" in {
    Zad12.isOrdered(Seq("ala","ma","psa"))(_ <= _) shouldBe true
  }
  it should "be false for sequences where ordering does not hold for the first two elements already" in {
    Zad12.isOrdered(Seq(2,1,5,6,7))(_ < _) shouldBe false
  }
  it should "be false for sequences where ordering does not hold in the middle of the sequence" in {
    Zad12.isOrdered(Seq(1,2,6,5,7))(_ < _) shouldBe false
  }
  it should "be false for sequences where ordering does not hold at the end of the sequence" in {
    Zad12.isOrdered(Seq(5,7,6))(_ < _) shouldBe false
  }
}
