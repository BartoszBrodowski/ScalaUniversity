@main
def zad1(): Unit = {
  val lines = io.Source
    .fromResource("./lab9/resources/nazwiska.txt")
    .getLines.toList

  val amountOfUniqs = lines.foldLeft(0)((acc, fullName) => {
    val name = fullName.split(" +").head

    val probableMax = name.groupBy(character => character.toLower).map(element => (element._1, element._2.length)).toList.length

    if (probableMax > acc) probableMax
    else acc
  })

  val listOfFullNames = lines.foldLeft(Nil: List[String])((acc, fullName) => {
    if (fullName
      .split(" +")
      .head
      .groupBy(character => character.toLower)
      .map(element => (element._1, element._2.length))
      .toList.length == amountOfUniqs) acc :+ fullName.split(" +").last
    else acc
  })

  println(listOfFullNames)
}

@main
def zad2(): Unit = {
  val lines = io.Source
    .fromResource("./lab9/resources/ogniem-i-mieczem.txt")
    .getLines.toList

  def histogram(max: Int): String = {
    val lettersCounter = lines
      .mkString
      .replaceAll("[^a-zA-ZąĄćĆęĘłŁńŃóÓśŚ]", "")
      .toLowerCase
      .groupBy(character => character.toLower)
      .map(element => (element._1, element._2.length))
      .toList

    lettersCounter.foldLeft("")((acc, pair) => {
      acc + s"\n${pair(0)}: ${"*" * max.min(pair(1))}"
    }).trim
  }

  println(histogram(120))
}