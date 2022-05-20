@main
def zad01: Unit = {
  val secret = List(1, 3, 2, 2, 4, 5)
  val guess  = List(2, 1, 2, 4, 7, 2)
  def blackCount[A](secret: List[A], guess: List[A]): Int = {
    secret.zipWithIndex.foldLeft(0)((prev, curr) => {
      if (curr._1 == guess(curr._2)) prev + 1
      else prev
    })
  }
  def whiteCount[A](secret: List[A], guess: List[A]): Unit = {
    println(secret.toSeq)
  }


  println(blackCount(secret, guess))
  whiteCount(secret, guess)
}
@main
def zad02: Unit = {
  class Zawodnik(val imie: String, val nazwisko: String, val wdziek: List[Int] = Nil, spryt: List[Int] = Nil) {
    def sredniWynikWdziek: Double = {
      wdziek.sum / wdziek.length
    }
    def sredniWynikSpryt: Double = {
      spryt.sum / spryt.length
    }
  }
  val zawodnik1 = new Zawodnik("Jan", "Kowalski", List(15, 8, 6, 20), List(12, 20, 11, 5))
  val zawodnik2 = new Zawodnik("Zofia", "Wieniawa", List(10, 8, 3, 16), List(19, 11, 13, 5))
  val zawodnik3 = new Zawodnik("Przemysław", "Okoń", List(13, 14, 13, 15, 16), List(20, 18, 15))  
  val listaZawodnikow = List(zawodnik1, zawodnik2, zawodnik3)

  def resultsHelper(zawodnicy: List[Zawodnik]): List[Zawodnik] = {
    zawodnicy.sortBy(zawodnik => zawodnik.sredniWynikWdziek).sortBy(zawodnik => zawodnik.sredniWynikWdziek + zawodnik.sredniWynikSpryt)
  }
  def results: Unit = {
    resultsHelper(listaZawodnikow).foreach(zawodnik => println(zawodnik.imie))
  }
  results
}




@main
def zad03: Unit = {
  println(threeNumbers(20))
  def threeNumbers(n: Int): Seq[(Int, Int, Int)] = {
    for {
      c <- 1 to n
      b <- 1 until c
      a <- 1 until b
      if (c * c == b * b + a * a)
    } yield (a, b, c)
  }
}