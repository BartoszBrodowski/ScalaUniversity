/*
    Wykorzystując rekurencję (wyłącznie ogonową) zdefiniuj funkcję:

        def countResults[A,B,C](l1: List[A], l2: List[B])(f: (A, B) => C): Set[(C, Int)]

    która zaaplikuje funkcję „f” do elementów l1(i), l2(i), gdzie 0 <= i < min(l1.length, l2.length)
    oraz zwróci zbiór składający się z par:

        (wynik funkcji f, liczba par dla których f zwróciła dany wynik).

    Przykładowo dla:

        countResults(List(1,2,3), List(4,5,4,6))(_+_) == Set((5,1), (7,2))

    ponieważ: 1+4 = 5, 2+5 = 7, 4+3 = 7, 6 pomijamy bo to „nadmiarowy” element w drugiej z list.

    W rozwiązaniu należy skorzystać z mechanizmu dopasowania do wzorca (pattern matching).
    Nie używaj zmiennych ani „pętli” (while, for bez yield, foreach).
*/
@main
def zad01: Unit = {
  println(countResults(List(1,2,3), List(4,5,4,6))(_+_))
}

def countResults[A,B,C](l1: List[A], l2: List[B])(f: (A, B) => C): Any = {
  countResultsHelper(l1, l2, List())(f).groupBy(x => x).map(x => (x._1, x._2.length)).toSet
}

def countResultsHelper[A,B,C](l1: List[A], l2: List[B], acc: List[C])(f: (A, B) => C): List[C] = {
  (l1, l2) match {
    case (Nil, l2) => acc
    case (l1, Nil) => acc
    case (h1::t1, h2::t2) => countResultsHelper(t1, t2, f(h1, h2) :: acc)(f)
  }
}

def main(args: Array[String]): Unit = {
        //...
}