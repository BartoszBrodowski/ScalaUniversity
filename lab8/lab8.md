## Laboratorium 08 – zadania

__Uwaga!__

W rozwiązaniach poniższych zadań nie używaj _zmiennych_. Nie definiuj też i nie wykorzystuj funkcji z użyciem _rekurencji_. Tam, gdzie to przydatne pamiętaj o wykorzystaniu „dopasowania wzorca”.


__Zadanie 30__: Korzystając z metod oferowanych przez kolekcję zdefiniuj metodę oceniania ruchów dla gry _MasterMind_ [zasady](https://www.zagrajsam.pl/dzialy_gier.php?gra=3).

__Przykład__:
```scala
val secret = List(1, 3, 2, 2, 4, 5)
val guess  = List(2, 1, 2, 4, 7, 2)
val black  = ???
val white  = ??? - black
```

Oczekiwane wartości to: `black` równe `1` oraz `white` równe `3`.

__Zadanie 31__: Napisz program, który oblicza wyniki zawodów sportowych w konkurencji, w której zawodnicy oceniani są w dwóch kategoriach:

- wdzięk
- spryt

Ocena „cząstkowa” ma postać:
```scala
("Imię", "Nazwisko", cena_wdzięku, ocena_sprytu)
```

Załóż, że:

- zawodnicy identyfikowani są poprzez imię i nazwisko
- każdy zawodnik może otrzymać dowolną liczbę ocen „cząstkowych”
- `ocena_wdzięku` oraz `ocena_sprytu` są dowolnymi liczbami całkowitymi z zakresu `[0..20]`.

Ostateczny wynik zawodnika jest to para liczb typu `Double` będących średnimi arytmetycznymi ocen cząstkowych w podanych powyżej „kategoriach”.

„Ranking” ustala się sumując obie „średnie” noty każdego z zawodników - wyższa suma oznacza lepszy wynik.

Jeśli sumy not dwóch zawodników są identyczne, to wyższe miejsce zajmuje ten, którego (średnia) nota za wdzięk była wyższa. Jeśli również noty za wdzięk są identyczne, to zawodnicy zajmuja miejsca ex-aequo.

Załóż, że dane wejściowe programu stanowi lista obiektów reprezentujących oceny „cząstkowe”. Program powinien stworzyć uporządkowaną listę obiektów reprezentujących informacje o:

- miejscu zajętym przez zawodnika
- imieniu i nazwisku zawodnika
- uzyskanym wyniku

W przypadku miejsc ex-aequo kolejność na liście wynikowej powinna być zgodna z porządkiem alfabetycznym __nazwisk__ zawodników.

W rozwiązaniu możesz wykorzystywać dowolne niemutowalne kolekcje języka Scala i wszelkie dostępne dla nich metody standardowe.

__Zadanie 32__: Korzystając z "pętli" `for/yield` zdefiniuj funkcję:
	
```scala	
def threeNumbers(n: Int): Seq[(Int, Int, Int)] = /* ... */
```

która zwróci sekwencję zawierającą wszystkie kombinacje trzech liczb: `(a, b, c)`, gdzie <em>a</em>, <em>b</em>, <em>c</em>,
są liczbami z przedziału [1, <em>n</em>], które są zgodne ze wzorem:
<em>a</em><sup>2</sup> + <em>b</em><sup>2</sup> = <em>c</em><sup>2</sup>, gdzie <em>a</em> < <em>b</em>.

Podpowiedź: Sposób wygenerowania ciągu liczb od z przedziału [<em>a</em>, <em>b</em>]: 
```scala
a until b.
```