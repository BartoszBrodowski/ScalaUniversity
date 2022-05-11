## Laboratorium 05 – zadania

__Zadanie 1__.
Korzystając z rekurencji ogonowej zdefiniuj generyczną funkcję:

```scala
def oczyść[A](l: List[A]): List[A] = {
    Nil
}
```

która w liście _l_ zamienia wszystkie podciągi powtarzających się elementów ich pojedynczymi wystąpieniami. Zdefiniuj funkcję korzystając ze wzorców. Nie używaj metod head i tail.

__Przykład__:

```scala
val lista = List(1, 1, 2, 4, 4, 4, 1, 3)
oczyść(lista) // ==> List(1, 2, 4, 1, 3)
```

__Zadanie 2__.

Korzystając z rekurencji ogonowej zdefiniuj generyczną funkcję:

```scala
def skompresuj[A](l: List[A]): List[(A, Int)] = {
    Nil
}
```

która zastępuje każdy „podciąg” powtarzających się wystąpień elementu `el` na liście _l_ parą `(el, długość_podciągu)`. Nie używaj metod head i tail.

__Przykład__:

```scala
val lista = List('a', 'a', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'd')
skompresuj(lista) // ==> List(('a', 2), ('b', 1), ('c', 3), ('a', 2), ('b', 1), ('d', 1))
```


__Zadanie 3__.
		
Zdefiniuj generyczną funkcję rekurencyjną:

```scala				
def isOrdered[A](l: List[A])(leq: (A, A) => Boolean): Boolean = {
    true
}
```
		
która sprawdzi czy elementy sekwencji _l_ są ułożone zgodnie 
z porządkiem _leq_. Zdefiniuj funkcję z użyciem rekurencji ogonowej.

__Przykład__:

```scala
val l = List(1, 2, 2, 5)
isOrdered(l)(_ < _) // ==> false
isOrdered(l)(_ <= _) // ==> true
```

__Zadanie 4__.
		
Zdefiniuj generyczną funkcję rekurencyjną:
```scala				
def applyForAll[A, B](l: List[A])(f: A => B): List[B] = = {
    Nil
}
```
która dla wszystkich elementów _l_ stosuje funkcję _f_.
Zdefiniuj funkcję z użyciem rekurencji ogonowej.

__Przykład__:

```scala
val l = List(1, 3, 5)
val f = (n) => n + 3
applyForAll(lista) // ==> List(4, 6, 8)
```
