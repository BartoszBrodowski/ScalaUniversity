object Main extends App {
  import scala.annotation.tailrec


  ////////// ZAD 1 ////////////


  // val lista = List(Some(4.0), Some(-3.0), Some(1.0), Some(0.0))

  // def sumuj(l: List[Option[Double]]): Option[Double] = {
  //   @tailrec
  //   def sumujHelper(arr: List[Option[Double]], acc: Int = 0): Option[Double] = {
  //     arr match {
  //       case List() => Some(acc)
  //       case head :: tail => 
  //         if (head.getOrElse(0.0) > 0) sumujHelper(tail, acc + head.get.toInt)
  //         else sumujHelper(tail, acc)
  //     }
  //   }
  //   sumujHelper(l)
  // }
  // println(sumuj(lista))


  //////////// ZAD 2 //////////////


  // val lista1 = List(2.0, -1.6, 3.2, 5.4, -8.4)
  // val lista2 = List(3.3, -3.1, 3.2, -4.1, -0.4, 5.5)
  // def maksimum(l1: List[Double], l2: List[Double]): List[Double] = {
  //   // @tailrec
  //   def helper(arr1: List[Double], arr2: List[Double], acc: List[Double]): List[Double] = {
  //     (arr1, arr2) match {
  //       case (Nil, Nil) => acc
  //       case (head1 :: tail1, Nil) => helper(tail1, arr2, acc :+ head1)
  //       case (Nil, head2 :: tail2) => helper(arr1, tail2, acc :+ head2)
  //       case (head1 :: tail1, head2 :: tail2) => 
  //         if (head1 > head2) helper(tail1, tail2, acc :+ head1)
  //         else helper(tail1, tail2, acc :+ head2)
  //     }
  //   }
  //   helper(l1, l2, List())
  // }
  // println(maksimum(lista1, lista2))


  //////// ZAD 3 ////////


    // val lista = List(2, 1, 4, 1, 3, 3, 1, 2)
    // def usun[A](l: List[A], el: A): List[A] = {
    //   @tailrec
    //   def usunHelper(lista: List[A], element: A, acc: List[A]): List[A] = {
    //     lista match {
    //       case Nil => acc
    //       case head :: tail => 
    //         if (head == el) usunHelper(tail, element, acc)
    //         else usunHelper(tail, element, acc :+ head)
    //     }
    //   }
    //   usunHelper(l, el, List())
    // }
    // println(usun(lista, 3))

    ////////////// ZAD 4 /////////////

    def divide[A](l: List[A]): (List[A], List[A]) = {
      @tailrec
      def divideHelper(l1: List[A], acc1: List[A], acc2: List[A], accLiczba: Int = 0): (List[A], List[A]) = {
        l1 match {
          case accLiczba % 2 == 0 => divideHelper(l1.tail, acc1 +: l1.head, acc2, accLiczba + 1)
        }
      }
    }
}