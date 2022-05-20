# Języki programowania 1

## Laboratorium 06 – zadania

__Uwaga!__

W rozwiązaniach poniższych zadań nie używaj _zmiennych_. Nie definiuj też i nie wykorzystuj funkcji z użyciem _rekurencji_. Tam, gdzie to przydatne pamiętaj o wykorzystaniu „dopasowania wzorca”.

__Zadanie 1__:

Korzystając z metod `drop` i `take` zdefiniuj generyczną funkcję:

```scala
def subseq[A](list: List[A], begIdx: Int, endIdx: Int): List[A] = {
    Nil
}
```

zwracającą podciąg listy `list`, złożony z elementów o indeksach z przedziału od `begIdx` do `endIdx`.

__Zadanie 2__:

Korzystając z metod `filter` i `partition` zdefiniuj funkcję:

```scala
def pairPosNeg(list: List[Double]): (List[Double], List[Double]) = {
    Nil
}
```

która podzieli listę `list` na parę list `(negative, positive)`, zawierających odpowiednio - wszystkie _ujemne_ oraz wszystkie _dodatnie_ elementy z listy `list`. W wyniki, elementy powinny występować w tej samej kolejności oraz krotności jak na liście `list`. Liczby równe `0.0` powinny zostać pominięte.

__Zadanie 3__:

Korzystając z metody z metod `slidding` i innych metod, zdefiniuj funkcję:
```scala
def isOrdered[A](seq: Seq[A])(leq:(A, A) => Boolean): Boolean = {
    true
}
```

która zwróci informację czy wszystkie sąsiednie elementy w `seq`,
są zgodne z predykatem `leq`.<br/>

__Przykład__:

```scala
val seq = Seq(1, 2, 2, 4)
isOrdered(seq)(_ < _) // ==> false
isOrdered(seq)(_ <= _) // ==> true
```
		
__Zadanie 4__:

Korzystając z metody `foldLeft` zdefiniuj generyczną funkcję

```scala
def deStutter[A](list: List[A]): List[A] = {
    Nil
}
```

usuwającą z listy `list` wszystkie powtarzające się podciągi.

__Przykład__:

```scala
val l = List(1, 1, 2, 4, 4, 4, 1, 3)
assert( deStutter(l) == List(1, 2, 4, 1, 3) ) // ==> true
```

__Zadanie 5__:

Używając metod `filter`, `map` i `zipWithIndex` zdefiniuj funkcję:

```scala
def remElems[A](list: List[A], k: Int): List[A] = {
    Nil
}
```

usuwającą `k`-ty element listy `list`.

__Zadanie 6__:

Używając poznanych na wykładzie metod przetwarzania kolekcji zdefiniuj funkcję:

```scala
def freqMax[A](list: List[A]): (Set[A],Int) = {
    Nil
}
```

która dla `list` zwraca parę zawierającą zbiór elementów, których liczba wystapień w `list` jest maksymalna oraz – jako drugi element pary – tę liczbę.

__Przykład__:

```scala
val l = List(1, 1, 2, 4, 4, 3, 4, 1, 3)
assert( freqMax(l) == (Set(1,4), 3) ) // ==> true
```

__Uwaga!__ Pamiętaj, że na wykładzie nie mówiliśmy jeszcze o operacjach „grupujących” `groupBy`, `groupMap` oraz `groupMapReduce`. Nie używaj ich więc w swoim rozwiązaniu :)
