val helloStr = "Hello, World!"

@main
def zad01: Unit = {
  val lista = List(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
  println(sumOpts(lista))
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
def zad02: Unit = {}

def position[A](l: List[A], el: A): Option[Int] = {
  None
}
