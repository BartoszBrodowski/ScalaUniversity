import scala.annotation.tailrec
@main
def zad01: Unit = {
  val lista = List(1, 1, 2, 4, 4, 4, 1, 3)
  println(oczyść(lista))
}
def oczyść[A](l: List[A]): List[A] = {
  helperOczyść(l, List())
}
@tailrec
def helperOczyść[A](l: List[A], l_acc: List[A]): List[A] = {
  (l, l_acc) match {
    case (head::tail, Nil) => helperOczyść(l, head :: l_acc)
    case (head1::tail1, head2::tail2) => if (head1 != head2) helperOczyść(tail1, head1 :: l_acc) else helperOczyść(tail1, l_acc)
    case (Nil, acc) => acc.reverse
  }
}

  
@main
def zad02: Unit = {
  val lista = List('a', 'a', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'd')
  println(skompresuj(lista))
}

def skompresuj[A](l: List[A]): List[(A, Int)] = {
    skompresujHelper(l, List())

}

def skompresujHelper[A](l: List[A], acc: List[(A, Int)], counter: Int = 1): List[(A, Int)] = {
  l match {
    case Nil => acc.reverse
    case head::Nil => skompresujHelper(Nil, (head, counter) :: acc, counter)
    case head1::(head::tail) => 
      if (head1 != head) skompresujHelper((head :: tail).toList, (head1, counter) :: acc, 1) 
      else skompresujHelper((head::tail).toList, acc, counter + 1)

  }
} 

@main
def zad03: Unit = {
  val l = List(1, 2, 2, 5)
  println(isOrdered(l)(_ <= _))
}

def isOrdered[A](l: List[A])(leq: (A, A) => Boolean): Boolean = {
    isOrderedHelper(l, true)(leq)
}

def isOrderedHelper[A](l: List[A], isTrue: Boolean = true)(leq: (A, A) => Boolean): Boolean = {
  (l, isTrue) match {
    case (Nil, true) => true
    case (l, false) => false
    case (head::Nil, true) => true
    case (head::(głowa::tail), true) => 
      if (leq(head, głowa)) isOrderedHelper((głowa :: tail), true)(leq)
      else false 

  }
}

@main
def zad04: Unit = {
  val l = List(1, 3, 5)
}