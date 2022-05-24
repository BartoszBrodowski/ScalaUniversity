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
def zadanieNowe: Unit = {
  println(countResults(List(1, 2, 3), List(4, 5, 4, 6))(_ + _))
  def countResults[A, B, C](l1: List[A], l2: List[B])(f: (A, B) => C): Set[(C, Int)] = {
    countResultsHelper(l1, l2, List())(f)
      .groupBy(x => x)
      .map(element => (element._1, element._2.length))
      .toSet
  }
  def countResultsHelper[A, B, C](l1: List[A], l2: List[B], acc: List[C])(
      f: (A, B) => C
  ): List[C] = {
    (l1, l2) match {
      case (Nil, Nil) => acc
      case (Nil, l2) => acc
      case (l1, Nil) => acc
      case (head1 :: tail1, head2 :: tail2) =>
        countResultsHelper(tail1, tail2, f(head1, head2) :: acc)(f)
    }
  }
}

// @main
// def zad01: Unit = {
//   println(countResults(List(1,2,3), List(4,5,4,6))(_+_))
// }

// def countResults[A,B,C](l1: List[A], l2: List[B])(f: (A, B) => C): Any = {
//   countResultsHelper(l1, l2, List())(f).groupBy(x => x).map(x => (x._1, x._2.length)).toSet
// }

// def countResultsHelper[A,B,C](l1: List[A], l2: List[B], acc: List[C])(f: (A, B) => C): List[C] = {
//   (l1, l2) match {
//     case (Nil, l2) => acc
//     case (l1, Nil) => acc
//     case (h1::t1, h2::t2) => countResultsHelper(t1, t2, f(h1, h2) :: acc)(f)
//   }
// }

// def main(args: Array[String]): Unit = {
//         //...
// }

@main
def zad02: Unit = {
  val lista02 = List(1, 2, 3, 4, 3, 3, 1)
  println(pairwiseTest(lista02)(_ == _))
  def pairwiseTest[A](l: List[A])(pred: (A, A) => Boolean): Boolean = {
    pairwiseTestHelper(l, 0, l.length - 1)(pred)
  }
  def pairwiseTestHelper[A](l: List[A], accFront: Int, accBack: Int)(
      pred: (A, A) => Boolean
  ): Boolean = {
    l match {
      case Nil => true
      case l =>
        if (pred(l(accFront), l(accBack)) == true) {
          if (accFront < accBack) pairwiseTestHelper(l, accFront + 1, accBack - 1)(pred)
          else true
        } else false
    }
  }
}
/*
Plik temepratury.txt zawiera w pierwszej kolumnie rok oraz w kolejnych dwunastu kolumnach
średnią temperaturę za każdy miesiąc w danym roku (kolejno: styczeń, luty, marzec itd.).
Dane dotyczące każdego roku rozdzielone są pojedynczymi spacjami.

Przykładowo:

    1779 -4.9 2.2 3.8 9.5 15.4 16.4 17.9 19.5 14.7 9.3 4.1 1.4
    1780 -5.1 -4.3 4.4 5.9 14.2 17.2 19.4 17.9 13.1 9.4 2.8 -4.6
    1781 -4.0 -1.9 1.5 9.1 13.8 19.2 20.1 22.8 16.2 6.0 4.0 -3.6

Zdefiniuj funkcję:

    def maxAvgTemps(data: List[String]): Set[(Int, Double)]

która wyznaczy maksymalną średnią temperaturę dla każdego miesiąca, zwracając zbiór par w formacie (miesiąc, temperatura):

    Set((1,3.5), (2,5.1), (3,7.4), (4,13.2), (5,18.2), (6,22.4), (7,23.5), (8,23.8), (9,16.8), (10,12.6), (11,7.6), (12,3.9))

Rozwiąż to zadanie używając metod oferowanych przez kolekcje. Nie używaj zmiennych, kolekcji
mutowalnych, "pętli" (while, for bez yield, foreach) oraz nie definiuj żadnej funkcji rekurencyjnej.

 */
@main
def zad03: Unit = {
  val data = io.Source
    .fromResource("temperatury.txt")
    .getLines()
    .toList
  println(maxAvgTemps(data))
}
def maxAvgTemps(data: List[String]): Set[(Int, Double)] = {
  data
    .map(row => row.split(" ").toList.map(char => char.toDouble))
    .foldLeft(List(1779, -4.9, 2.2, 3.8, 9.5, 15.4, 16.4, 17.9, 19.5, 14.7, 9.3, 4.1, 1.4))(
      (prev, curr) => {
        curr.zip(0 until 13).map(pair => prev(pair._2).max(pair._1))
      }
    )
    .zip(0 until 13)
    .map(el => (el._2, el._1))
    .slice(1, 13)
    .toSet
}
/*
    Korzystając wyłącznie z mechanizmów kolekcji języka Scala znajdź kraj o najdłużej rosnącym wskaźniku LadderScore.
    Innymi słowy, korzystając z załączonych danych szukamy kraju, dla którego wskaźnik LadderScore najdłużej
    utrzymał „dobrą passę” (z roku na rok się zwiększał).

    Zwróć uwagę na to, że w danych mogą wystąpić „linie” z brakującymi danymi. Takie linie powinny zostać
    POMINIĘTE. Brakujące dane oznaczają, że w linii występują sekwencje postaci: ,,, przykładowo:

        Kosovo,2020,6.294,,0.792,,0.880,,0.910,0.726,0.201

    Linie takie, jako „niewiarygodne” należy pominąć (oczywiście nie zmieniając samego pliku danych)
    zanim program rozpocznie analizę.

    W razwiązaniu nie wolno uzywać zmiennych, ani konstrukcji imperatywnych, takich jak pętle
 */
@main
def zad04: Unit = {
  val wyniki = io.Source
    .fromResource("world-happiness-report.csv")
    .getLines()
    .toArray
  def main(args: Array[String]): Unit = {
    val wyniki = io.Source
      .fromResource("world-happiness-report.csv")
      .getLines()
      .toArray
      .map(el => el.split(",").toList.slice(0, 3))
      .foldLeft(List(): List[List[String]])((acc, el) => {
        if (el.length == 3) acc :+ el
        else acc
      })
      .map(el => (el(0), el(1), el(2)))
      .sortBy(el => (el._1, el._2))
      .groupBy(el => el._1)
      .map(el =>
        (
          el._1,
          el._2.foldLeft(("": String, 0.0: Double, 0: Int, 0: Int))((acc, curr) => {
            if (acc._1 == "") (curr._2, curr._3.toDouble, 0, 0)
            else if (acc._1.toInt == curr._2.toInt - 1 && acc._2 < curr._3.toDouble)
              if (acc._3 < acc._4) (curr._2, curr._3.toDouble, acc._4 + 1, acc._4 + 1)
              else (curr._2, curr._3.toDouble, acc._3, acc._4 + 1)
            else (curr._2, curr._3.toDouble, acc._3, 0)
          })
        )
      )
      .map((a, b) => (a, b._3))
      .toList
    val maxVal = wyniki.foldLeft(0: Int)((acc, el) => {
      if (acc < el._2) el._2
      else acc
    })
    for (el <- wyniki) {
      if (el._2 == maxVal) {
        println(el)
      }
    }
    println(wyniki)
  }
  main(wyniki)
}

/*
    Korzystając wyłącznie z operacji na kolekcjach (w szczególności nie możesz uzyć rekurencji
    ani mechanizmów imperatywnych, takich jak zmienne i pętle) zdefiniuj funkcję:

        def findPairs(n: Int): Set[(Int,Int)]

    taką, że dowolnej liczby całkowitej N > 1

        findPairs(N)

    zawiera wszystkie pary postaci (p1, p2), gdzie p1 i p2 są liczbami
    pierwszymi takimi, że p1 + p2 = 2 * N oraz p1 <= p2.

 */
// @main
// def zad05: Unit = {
//   def findPairs(n: Int): Set[(Int,Int)] = {
//     if (n % 2 == 0) {
//       return Set()
//     }
//     else if ()
//   }

// }
