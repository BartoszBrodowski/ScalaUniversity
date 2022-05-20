val helloStr = "Hello, World!"

@main
def zad01: Unit = {
  val lista01 = List(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
  println(sumOpts(lista01))
}

def sumOpts(l: List[Option[Double]]): Option[Double] = {
  if (l != Nil || l.forall(x => x != None)) {
    l.reduce((prev, curr) => {
      if (curr.isEmpty) prev
      else Option(prev.get + curr.get)
    })
  } else None
}

@main
def zad02: Unit = {
  val lista02 = List(2, 1, 1, 5)
  println(position(lista02, 5))
}

def position[A](l: List[A], el: A): Option[Int] = {
  if (l.isEmpty) None
  else if (l.forall(x => x != el)) None
  else Option(l.indexOf(el))
}

@main
def zad03: Unit = {
  val lista03 = List(1, 2, 1, 1, 5)
  println(indices(lista03, 3))
}
def indices[A](l: List[A], el: A): Set[Int] = {
  indicesHelper(l, List(), el).reverse.tail.toSet
}
def indicesHelper[A](l: List[A], lAcc: List[Int], el: A): List[Int] = {
  l.zipWithIndex.foldLeft(List(0))((prev, curr) =>
    if (curr._1 == el) curr._2 :: prev
    else prev
  )
}

@main
def zad04: Unit = {
  val lista04 = List(1, 2, 3, 4, 5)
  println(swap(lista04, List()))
}
def swap[A](l: List[A], listAcc: List[A]): Unit = {
  l.sliding(2, 2).foreach(x => x.reverse.foreach(element => element :: listAcc))
}

// @main
// def zad05: Unit = {

// }

@main
def zad06: Unit = {
  val lista06 = List('a', 'b', 'a', 'c', 'c', 'a')
  println(freq(lista06))
}
def freq[A](l: List[A]): List[(A, Int)] = {
  l.groupBy(x => x).map(x => (x.head, x(1).length)).toList
}
