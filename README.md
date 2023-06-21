# Coding-Standards-Best-Practices

## 1. Clean Code

- You Aren't Gonna Need It - nie komplikuj, rób tylko tyle ile jest w zadaniu, pomyśl czy warto coś wprowadzać
  KISS - rozwiązanie powinno być wykonane w jak najprostrzy sposób.
  Za pomocą obu powyższych reguł oszczędzamy czas. Można tych zasad nie stosować, jeśli tym kodem nie zwiekszamy złożoności oprogramowania. Martin Fowler
- warto korzystać ze statycznych metod fabrycznych - np. tworzenie nowych obiektów Klasa.of
- statyczne pole np. typu boolean może przechowywać flagi
- metody powinny mieć jak mniej parametrów
- metody powinny mieć jeden poziom wcięcia (jeśli metoda ma więcej niż 2 wcięcia należy wydzielić metodę)
- nie mieszać ważnych koncepcji ze szczegółami implementacyjnymi (wynosić mniejsze kawałki kodu)
- na górze klasy umieszczamy metody z wysokim poziomem abstrakcji a idąc w dół z coraz mniejszeym
- nazwę metody można nawet zmienić za jakiś czas
- nazwa metody powinna być zrozumiała, zgodna z kontekstem użycia, bez nadmiarowych informacji, nazwa zgodna z użyciem
- nazwy powinny być wyróżnialne, klasa rzeczownik, metoda czasownik
- unikaj nie jasności w nazwach
- kod powinien być łatwo czytelny jak książka, więcej czasu czytamy kod niż go piszemy
- zamieniamy BigDecimal na ValueObjecty
  np. zamiast dt - currentDate
  zamiast execute - generateRaport

### a) Kryteria oceny kodu:

- efektywność
- złożoność minimalna
- zrozumiałość
- reużywalność
- utrzymywalność
- testowalność
