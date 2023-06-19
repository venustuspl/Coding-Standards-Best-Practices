# Coding-Standards-Best-Practices

1. Clean Code
...a) You Aren't Gonna Need It - nie komplikuj, rób tylko tyle ile jest w zadaniu, pomyśl czy warto coś wprowadzać
...b) KISS - rozwiązanie powinno być wykonane w jak najprostrzy sposób.
Za pomocą obu powyższych reguł oszczędzamy czas. Można tych zasad nie stosować, jeśli tym kodem nie zwiekszamy złożoności oprogramowania. Martin Fowler
...c) warto korzystać ze statycznych metod fabrycznych - np. tworzenie nowych obiektów Klasa.of
...d) statyczne pole np. typu boolean może przechowywać flagi
*e) metody powinny mieć jak mniej parametrów
f) metody powinny mieć jeden poziom wcięcia (jeśli metoda ma więcej niż 2 wcięcia należy wydzielić metodę)
g) nie mieszać ważnych koncepcji ze szczegółami implementacyjnymi (wynosić mniejsze kawałki kodu)
h) na górze klasy umieszczamy metody z wysokim poziomem abstrakcji a idąc w dół z coraz mniejszeym
i) nazwę metody można nawet zmienić za jakiś czas
j) nazwa metody powinna być zrozumiała, zgodna z kontekstem użycia, bez nadmiarowych informacji, nazwa zgodna z użyciem
k) nazwy powinny być wyróżnialne, klasa rzeczownik, metoda czasownik
l) kod powinien być łatwo czytelny
np. zamiast dt - currentDate
zamiast execute - generateRaport


