import scala.annotation.tailrec
// LAB 1

@main
def zad01(): Unit = {
  @tailrec
  def reverse(str: String, wynik: String = ""): String = {
      if (str.length == 0) return wynik
      else reverse(str.tail, str.head + wynik)
  }
  println(reverse("Chomik"))
}

@main
def zad02(): Unit = {
  def pierwsza(n: Int): Boolean = {
    @tailrec
    def pierwszaHelper(x: Int, acc: Int): Boolean = {
      if (x <= 1) false
      else if (acc < 2 && x > 2) true
      else if (x % acc == 0) false
      else pierwszaHelper(x, acc - 1)
    }
    pierwszaHelper(n, Math.floor(n/2).toInt)
  }
  println(pierwsza(5))
}

@main
def zad03(): Unit = {
  def ciąg(n: Int): Int = {
    @tailrec
    def ciągHelper(x: Int, acc0: Int, acc1: Int): Int = {
      if (x == 0) acc0
      else if (x == 1) acc1
      else ciągHelper(x - 1, acc1, acc0 + acc1)
    }
    ciągHelper(n, 2, 1)
  }
  println(ciąg(5))
}

@main
def zad04(): Unit = {
  val list1 = List(2, 4, 3, 5)
  val list2 = List(1, 2, 2, 3, 1, 5)
  def tasuj(l1: List[Int], l2: List[Int]): List[Int] = {
    def tasujHelper(l1: List[Int], l2: List[Int], acc: List[Int] = List()): List[Int] = {
      if (l1.length == 0 && l2.length == 0) acc
      else if (l1 == Nil && l2 != Nil) tasujHelper(l1, l2.tail, acc :+ l2.head)
      else if (l1 != Nil && l2 == Nil) tasujHelper(l1.tail, l2, acc :+ l1.head)
      else if (l1.head < l2.head) tasujHelper(l1.tail, l2, acc :+ l1.head)
      else if (l1.head > l2.head) tasujHelper(l1, l2.tail, acc :+ l2.head)
      else if (l1.head == l2.head) tasujHelper(l1, l2.tail, acc)
      else acc
    }
    tasujHelper(list1, list2, List())
  }
  println(tasuj(list1, list2))
}