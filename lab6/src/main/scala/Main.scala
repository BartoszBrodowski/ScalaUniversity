val helloStr = "Hello, World!"

@main
def zad01(): Unit = {
  val lista = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  println(subseq(lista, 3, 7))
}
def subseq[A](list: List[A], begIdx: Int, endIdx: Int): List[A] = {
  list.drop(begIdx).take(endIdx - begIdx)
}

@main
def zad02(): Unit = {
  val listaZad2 = List(-2.0, 1.0, -3.0, 2.0, 4.0, 5.0, -7.0, -9.0)
  println(pairPosNeg(listaZad2))
}
def pairPosNeg(list: List[Double]): (List[Double], List[Double]) = {
  list.filter(_ != 0).partition(_ < 0)
}

@main
def zad03(): Unit = {
  val seq = Seq(1, 2, 2, 4)
  println(isOrdered(seq)(_ <= _))
}

def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = {
  seq
    .sliding(2, 1)
    .toList
    .foldLeft(true)((acc, element) =>
      if (leq(element.head, element(1))) acc
      else false
    )
}

@main
def zad04: Unit = {
  val l = List(1, 1, 2, 4, 4, 4, 1, 3)
  println(deStutter(l))
}

def deStutter[A](list: List[A]): List[A] = {
  deStutterHelper(list).reverse
}

def deStutterHelper[A](list: List[A]): List[A] = {
  list.foldLeft(List(list.head): List[A])((acc, element) =>
    if (element != acc.head) element :: acc
    else acc
  )
}

@main
def zad05: Unit = {
  val lista05 = List(1, 2, 3, 4, 5)
  println(remElems(lista05, 2))
}

def remElems[A](list: List[A], k: Int): List[A] = {
  list.zipWithIndex.filter(_._2 != k).map(element => element._1)
}

@main
def zad06: Unit = {
  val l = List(1, 1, 2, 4, 4, 3, 4, 1, 3)
  println(freqMax(l))
}

def freqMax[A](list: List[A]): Unit = {
  val setWithCounters = list.toSet.map(element => (element, list.count(num => num == element)))
  val max = setWithCounters.maxBy((_, howMuch) => howMuch).toList(1)
  setWithCounters.filter((_, counter) => counter == max)
}
