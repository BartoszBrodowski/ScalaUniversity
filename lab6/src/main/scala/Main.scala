val helloStr = "Hello, World!"

@main
def zad01(): Unit = {
  val lista = List(1,2,3,4,5,6,7,8,9,10)
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
  val seq = Seq(1,2,2,4)
  println(isOrdered(seq)(_ <= _))
}

def isOrdered[A](seq: Seq[A])(leq:(A, A) => Boolean): Boolean = {
    seq.sliding(2, 1).toList.foldLeft(true)((acc, element) => 
      if (leq(element.head, element(1))) acc
      else false
    )
}


@main
def zad04: Unit = {
  val l = List(1, 1, 2, 4, 4, 4, 1, 3)
  println(deStutter(l).reverse)
}

def deStutter[A](list: List[A]): List[A] = {
    list.foldLeft(List(list.head): List[A])((acc, element) => 
      if (element != acc.head) element :: acc
      else acc
    )
}
