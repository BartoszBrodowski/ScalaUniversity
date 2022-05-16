## Laboratorium 07 – zadania

__Uwaga!__

W rozwiązaniach poniższych zadań nie używaj _zmiennych_. Nie definiuj też i nie wykorzystuj funkcji z użyciem _rekurencji_. Tam, gdzie to przydatne pamiętaj o wykorzystaniu „dopasowania wzorca”.

__Zadanie 24__:

Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
```scala
def sumOpts(l: List[Option[Double]]): Option[Double] = {
    None
}
```
zwracającą (opcjonalną) sumę elementów listy będącej jej argumentem. Wszystkie elementy `None` powinny zostać pominięte, a jeśli lista będąca argumentem jest pusta bądź składa się wyłącznie z elementów `None` wówczas wynikiem również powinno być `None`.

__Przykład__:
```scala
val lista = List(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
assert( sumOpts(lista) == Some(7.0) )       // ==> true
assert( sumOpts(List()) == None)            // ==> true
assert( sumOpts(List(None, None)) == None)  // ==> true
```

__Zadanie 25__:

Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
```scala
def position[A](l: List[A], el: A): Option[Int] = {
    None
}
```
zwracającą pierwszy indeks na liście `l`, na którym znajduje się element `el`. W przypadku braku elementu, funkcja powinna zwrócić wartość `None`.

__Przykład__:
```scala
val lista = List(2, 1, 1, 5)
position(lista, 1) // ==> Some(1)
position(lista, 3) // ==> None
```

__Zadanie 26__:
Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
```scala
def indices[A](l: List[A], el: A): Set[Int] = {
    Set()
}
```
zwracającą wszystkie indeksy w liście `l`, na których znajduje się element `el`.

__Przykład__:
```scala
val lista = List(1, 2, 1, 1, 5)
indices(lista, 1) // ==> Set(0, 2, 3).
indices(lista, 7) // ==> Set()
```

__Zadanie 27__:
Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
```scala
def swap[A](l: List[A]): List[A] = {
    Nil
}
```
zamieniającą kolejnością wartości znajdujące się na parzystych i nieparzystych indeksach.

__Przykład__:
```scala
val lista = List(1, 2, 3, 4, 5)
swap(lista) // ==> List(2, 1, 4, 3, 5)
```

__Zadanie 28__:
Korzystając z ciągu wszystkich stref czasowych (postaci Kontynent/Strefa):
```scala
val strefy: List[String] = java.util.TimeZone.getAvailableIDs.toList
```
oraz operacji na ciągach i zasugerowanej poniżej operacji `stripPrefix`, wyszukaj strefy znajdujące się w Europie i posortuj rosnąco ich nazwy względem długości. Strefy, których nazwy mają taką samą długość posortuj w kolejności alfabetycznej.

__Podpowiedź__: wykorzystaj (między innymi) standardową operację na napisach:
```scala
def stripPrefix(prefix: String): String
```
pozwalającą usuwać podany prefiks z napisu, np.
```scala
"ala ma kota".stripPrefix("ala ") // ==> "ma kota"
```

__Zadanie 29__: Korzystając z metod oferowanych przez kolekcje, a w szczególności z metody `groupBy` zdefiniuj funkcję:
```scala
def freq[A](l: List[A]): List[(A, Int)] = {
    Nil
}
```
zwracającą informację o częstości występowania poszczególnych elementów na liście `l`.

__Przykład__:
```scala
val lista = List('a','b','a','c','c','a')
freq(lista) // ==> List(('a', 3),('b', 1),('c', 2))
```

