import org.scalatest._

class Zad13Test extends FlatSpec with Matchers {
  "insertInto" should "properly insert an element into empty sequence" in {
    Zad13.insertInto(99, Seq())(_ <= _) shouldBe Seq(99)
  }
  it should "properly insert an element in the middle of a non-empty sequence" in {
    Zad13.insertInto(99, Seq(1,2,100))(_ <= _) shouldBe Seq(1,2,99,100)
  }
  it should "properly insert an element at the beginning of a non-empty sequence" in {
    Zad13.insertInto('a', Seq('b','c','d'))(_ <= _) shouldBe Seq('a','b','c','d')
  }
  it should "properly insert an element at the end of a non-empty sequence" in {
    Zad13.insertInto('e', Seq('b','c','d'))(_ <= _) shouldBe Seq('b','c','d','e')
  }
}
