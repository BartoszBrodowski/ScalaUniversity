package jp1.akka.lab13.model

import akka.actor.{Actor, ActorRef, Props}
import akka.actor.PoisonPill

val akkaPathAllowedChars = ('a' to 'z').toSet union
  ('A' to 'Z').toSet union
  "-_.*$+:@&=,!~';.)".toSet

object Organizator {
  case object Start
  // rozpoczynamy zawody – losujemy 50 osób, tworzymy z nich zawodników
  // i grupę eliminacyjną
  case object Runda
  // polecenie rozegrania rundy (kwalifikacyjnej bądź finałowej) –  wysyłamy Grupa.Runda
  // do aktualnej grupy
  case object Wyniki
  // polecenie wyświetlenia klasyfikacji dla aktualnej grupy
  case class Wyniki(w: Map[ActorRef, Option[Ocena]])
  // wyniki zwracane przez Grupę
  case object Stop
  // kończymy działanie
}

class Organizator extends Actor {
  // importujemy komunikaty na które ma reagować Organizator
  import Organizator._

  def receive: Receive = {
    case Start =>
      // tworzenie 50. osób, opdowiadających im Zawodników
      // oraz Grupy eliminacyjnej
      
      val zawodnicy = List.fill(50) {
        val o = Utl.osoba()
        context.actorOf(Props(Zawodnik(o)), s"${o.imie}-${o.nazwisko}" filter akkaPathAllowedChars)
      }
      // ...
      val grupa = context.actorOf(Props(Grupa(zawodnicy)), "grupa_eliminacja")
      context.become(eliminacje(grupa))
    // Obsługa pozostałych komunikatów

    case Stop =>
      println("kończymy zawody...")
      context.system.terminate()
  }
  def eliminacje(grupa: ActorRef): Receive = {
    case "eliminacje" => 
      grupa ! Grupa.Runda
      context.become(przyjmujeOceny(Map(): Map[ActorRef, Option[Ocena]]))
    }
  def przyjmujeOceny(mapaOcen: Map[ActorRef, Option[Ocena]]): Receive = {
    case (imie: ActorRef, ocenaZawodnika: Option[Ocena]) =>
      val klucz = imie
      val wartosc = ocenaZawodnika
      context.become(przyjmujeOceny(mapaOcen + (klucz -> wartosc)))
      if (mapaOcen.toList.length == 49) {
        // println((mapaOcen + (klucz -> wartosc)).toList.length)
        sender() ! PoisonPill
        println((mapaOcen + (klucz -> wartosc)).groupBy((aktor, wartosc) => {
          if (wartosc == None) {
            0
          } else {
            wartosc.get.nota1 + wartosc.get.nota2 + wartosc.get.nota3
          }
        }).toList.sortBy(nazwa => -nazwa._1))
      }
  }
}
