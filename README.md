# Coding-Standards-Best-Practices

## 1. Clean Code

- You Aren't Gonna Need It - nie komplikuj, rób tylko tyle ile jest w zadaniu, pomyśl czy warto coś wprowadzać
  KISS - rozwiązanie powinno być wykonane w jak najprostrzy sposób.
  Za pomocą obu powyższych reguł oszczędzamy czas. Można tych zasad nie stosować, jeśli tym kodem nie zwiekszamy złożoności oprogramowania. Martin Fowler
- warto korzystać ze statycznych metod fabrycznych - np. tworzenie nowych obiektów Klasa.of
- statyczne pole np. typu boolean może przechowywać flagi
- metody powinny mieć jak mniej parametrów
- metoda powinna mieć jeden cel
- metody powinny mieć jeden poziom wcięcia (jeśli metoda ma więcej niż 2 wcięcia należy wydzielić metodę)
- nie mieszać ważnych koncepcji ze szczegółami implementacyjnymi (wynosić mniejsze kawałki kodu)
- na górze klasy umieszczamy metody z wysokim poziomem abstrakcji a idąc w dół z coraz mniejszeym
- nazwę metody można nawet zmienić za jakiś czas
- nazwa metody powinna być zrozumiała, zgodna z kontekstem użycia, bez nadmiarowych informacji, nazwa zgodna z użyciem
- nazwy powinny być wyróżnialne, klasa rzeczownik, metoda czasownik
- unikaj nie jasności w nazwach
- używając dobrze nazwanych stałych sprawiamy, że kod staje się czytelniejszy
- kod powinien być łatwo czytelny jak książka, więcej czasu czytamy kod niż go piszemy
- uczcąc się pisania czystego kodu można robić lepsze code review
- należy budować nawyk refaktoryzacji, czyli np. zmiana nazwy
- aby pisać czysty kod należy poznać fundamenty: hermetyzacja, zasady solid, grasp
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

## 2. Hermetyzacja

- nie używanie hermetyzacji powoduje: wycieki logiki, brak kontroli nad zmianą, utrudniona czytelność, duży coupling
- zmiany powinny się odbywać na danym obiekcie, ewentualnie na klasach, które kożystają z tego obiektu
  . wystawiając interfejs zmniejszamy coupling obiektów
- hermetyzacja to wystawienie abstrakcji a nie wystawienie getterów i setterów, które zawierają nazwy pól
- logika powinna być w jednym miejcu, czyli np. na obiekcie
- metody biznesowe to takie, które odwzorowują rzeczywistość
- nazwa metody ma mówić co się w niej wykona
- jeśli zmieniamy status obiektu to taka metoda powinna być w obiekcie
- anemiczny obiekt to antywrzozec programowania obiektowego, który nie posiada metod
- pola i klasy z reguły ustawiamy na private - nie udostępniamy na zewnątrz
- zaletami hermetyzacji są: kontrola dostępu, testowalność, SRP, czytelność kodu, wymienialność
- Prawo Demeter - obiekt może komunikować się z bezpośrednimi obiektami (jedna kropa) / obiekty przekazane do metody, dostępne glolablnie, stworzone przez metode, dostępne we właściwościach klasy. Dany obiekt nie może zaglądać do wnętrza obiektów którymi manipuluje. Jedna klasa nie powinna wiedzieć wszystkiego o innych klasach. Np. klasa Company o Eemployee i Team. Metody wyliczające dane w departamentach powinny znajdować się w departamentach.
- do konkretnych metod warto przekazywać interfejsy, żeby nie być zależnym od konkretnej implementacji na obiekcie

## 3. Value Objects

- obiekty niezmienne to takie, które zostały zainicjalizowane w konstruktorze i ich stan się nie zmienia bo nie mają getterów i setterów, takie obiekty zapewniają bezpieczeństwo i testowalność
- pola powinny być private final
- zmieniając taki obiekt tworzymy nową instancję
- defensywana kopia - najpierw tworzymy kopie obiektu a później kopjujemy dane
- klasa nie powinna być rozszrzalna - final class lub statyczna metoda fabryczna: ofKilometers
- zalety: używanie w wątkach, hermetyzacja, materiał do budowy nowych obiektów, zawsze te same wartości
- wady: zmieniając coś zawsze trzeba tworzyć nowy obiekt
- łątwiej tworzyć małe obiekty niezmienne, w dużych należey ograniczyć możliwość zmiany
- wrzozec Value Object zwiększa czytelność kodu
- wrzozec Value Object jest cześcią koncepcji DDD
- aby utworzyć value objecty zbieramy zbieramy grupy wartości
- obiekt vo powinien być niezmienny, w konstruktorze powinna być walidacja
- Lista<Emaili> jest czytelniejsza niż Lista<Stringów>
- vo najlepiej urzywać w wątkach
- vo redukuje użycie typów prymitywnych
- vo wprowadzamy jeśli widzimy z tego większą kożyść niż prracę
- vo tworzymy wydzielając parametry, które można pogrupować
- dzięki dobrej nazwie od razu wiemy co zawiera vo np. PriceDiscount (kod staje się czytelniejszy)
