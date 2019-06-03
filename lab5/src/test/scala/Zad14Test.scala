import org.scalatest._

class Zad14Test extends FlatSpec with Matchers {
  "deStutter" should "properly handle empty sequence" in {
    Zad14.deStutter(Seq()) shouldBe Seq()
  }
  it should "properly handle single-element sequences" in {
    Zad14.deStutter(Seq(1)) shouldBe Seq(1)
  }
  it should "properly handle non-empty sequences of type Int" in {
    Zad14.deStutter(Seq(0,0,0,1,1,1,2,2,3,4,4,1,1)) shouldBe Seq(0,1,2,3,4,1)
  }
  it should "properly handle non-empty sequences of type Char" in {
    Zad14.deStutter(Seq('a','a','c','d','d','d','e','e')) shouldBe Seq('a','c','d','e')
  }
}
