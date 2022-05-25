@main
def p01: Unit = {
  val lista = List(1, 1, 2, 3, 5, 8)
  def lastElementOfList[A](lista: List[A]): A = {
    lista.last
  }
  println(lastElementOfList(lista))
}

@main
def p07: Unit = {
  val listaP07 = List(List(1, 1), 2, List(3, List(5, 8)))
  def flattenNestedList(lista: List[Any]): List[Any] = {
    lista flatMap({
    case ms: List[_] => flattenNestedList(ms)
    case e => List(e)
    }) 
  }
  println(flattenNestedList(listaP07))
}

@main
def p08: Unit = {
  val listaP08 = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
  def compress[A](lista: List[A]): Any = {
    lista.foldLeft(List[A]())((acc, curr) => {
      if (acc.isEmpty || acc.last != curr) acc :+ curr
      else acc
    })
    // lista.foldLeft(List(lista.head))((acc, curr) => {
    //   if (acc.last != curr) acc :+ curr
    //   else acc
    // })
  }
  println(compress(listaP08))
}

@main
def p14: Unit = {
  val listaP14 = List("a", "b", "c", "c", "d")
  def duplicate[A](lista: List[A]): Any = {
    lista flatMap {(el => List(el, el))}
  }
  println(duplicate(listaP14))
}

@main
def p15: Unit = {
  val listP15 = List("a", "b", "c", "c", "d")
  def duplicateN[A](ls: List[A], n: Int): List[A] = {
    duplicateHelper(ls, n, List(), n)
  }
  def duplicateHelper[A](ls: List[A], n: Int, listAcc: List[A], accNum: Int): List[A] = {
    ls match {
      case head::tail => 
        if (accNum > 0) duplicateHelper(ls, n, listAcc :+ head, accNum - 1)
        else duplicateHelper(tail, n, listAcc, n)
      case Nil => listAcc
    }
  }
  println(duplicateN(listP15, 3))
}
@main
def testP15: Unit = {
  val listTestP15 = List("a", "b", "c", "c", "d")
  def testDuplciate[A](lista: List[A], n: Int): List[A] = {
    lista.flatMap(el => List.fill(n)(el))
  }
  println(testDuplciate(listTestP15, 3))
}

@main
def P16: Unit = {
  val listaP16 = List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
  def dropEveryNthElement[A](lista: List[A], n: Int, accNum: Int = 0, accList: List[A] = List()): List[A] = {
    if (accNum == lista.length) accList
    else {
      lista match {
        case head::tail => 
          if (accNum % n == n - 1) dropEveryNthElement(lista, n, accNum + 1, accList)
          else dropEveryNthElement(lista, n, accNum + 1, accList :+ lista(accNum))
      }
    }
  }
  println(dropEveryNthElement(listaP16, 4))
  // def dropEveryHelper[A](lista: List[A], n: Int, listAcc: List[A]): List[A] = {
    
  // }
}