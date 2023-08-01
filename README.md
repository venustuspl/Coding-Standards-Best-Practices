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
  np. zamiast dt - currentDate zamiast execute - generateRaport

### Clean Code wg. Bard

Czysty kod w Javie to taki kod, który jest łatwy do zrozumienia, testowania i utrzymania. Powinien on być również spójny i zgodny z konwencjami nazewnictwa oraz stylem kodu.

Oto kilka założeń, jakie powinien spełniać czysty kod w Javie:

Kod powinien być czytelny. To oznacza, że powinien być napisany w jasny i prosty sposób, bez użycia skrótów i żargonu. Nazewnictwo zmiennych, klas i metod powinno być również jasne i opisowe.
Kod powinien być logiczny. To oznacza, że powinien być łatwy do zrozumienia i logicznego śledzenia. Zadania powinny być podzielone na małe, łatwe do zrozumienia kroki.
Kod powinien być spójny. To oznacza, że powinien być napisany w jednolitym stylu i zgodnie z konwencjami nazewnictwa.
Kod powinien być testowalny. To oznacza, że powinien być łatwy do testowania za pomocą testów jednostkowych.
Kod powinien być utrzymywalny. To oznacza, że powinien być łatwy do modyfikowania i rozbudowywania bez wprowadzania błędów.
Oto kilka dodatkowych wskazówek dotyczących pisania czystego kodu w Javie:

Stosuj komentarze z umiarem. Komentarze powinny być używane tylko wtedy, gdy kod nie jest jasny sam w sobie.
Stosuj konwencje nazewnictwa. Konwencje nazewnictwa ułatwiają zrozumienie kodu przez innych programistów.
Stosuj narzędzia do formatowania kodu. Narzędzie do formatowania kodu może pomóc w utrzymaniu spójnego stylu kodu.
Stosuj narzędzia do testowania kodu. Testy jednostkowe mogą pomóc w zapewnieniu jakości kodu.
Pisanie czystego kodu wymaga czasu i wysiłku, ale jest to inwestycja, która się opłaca. Czysty kod jest łatwy do zrozumienia, testowania i utrzymania, co może prowadzić do szybszego rozwoju, mniejszej liczby błędów i lepszej jakości kodu.

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
- możesz przekazać do metody do obiektu jakiś interfejs(taki interface z Java), dzięki czemu możesz skorzystać z różnych serwisów, które są skomplikowane, a wtedy obiekt nie będzie zależny od implementacji. A także umożliwii wykorzystanie np. bazy danych lub inne integracje, które są w innym pakiecie, do którego ten obiekt nie ma dostępu. Sama dana klasa wystawia jakiś swój interfejs (nie w sensie Javy). Czyli dany obiekt ma jakieś publiczne metody biznesowe i na ich podstawie tylko możemy komunikować się z tym obiektem. Właśnie za pomocą tego interfejsu (tych metod biznesowych). Nie mamy dostępu do implementacji tej klasy, czyli do konkretnych pól i do ciała tych metod biznesowych. Wykorzystując same proste settery, które ustawiają tylko wartość, a logika biznesowa jest porozsiewana po innych klasach to tak naprawdę udostępniamy implementację
- najlepiej nie korzystać z adnotacji @Setter z lomboka No bo to tworzy zwykłego settera a my raczej chcemy tworzyć metody bieznesowe
  Przy mapowaniu możemy tworzyć od razu cały obiekt za pomocą konstruktora czy buildera. Wtedy nie musimy tworzyć setterow.

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

## 4. Solid

- SOLID to mnemonik pięciu zasad:

- S – SRP – Single responsibility principle - jedna odpowiedzialność czyli jeden powód do zmiany, np. Person nie powinien zmieniać adresów, lub zajmować się walidacją emaili
- O – OCP – Open/Closed principle - klasa powinna być „otwarta na rozszerzenia a zamknięta na modyfikacje”. Uściślając – nie powinno dojść do sytuacji w której trzeba modyfikować kod. Jest to zabronione, gdyż zmiana deklaracji metody może spowodować błędne działanie w innych miejscach systemu. Np. tworząc klasych pochode Shape typu Circle, Square powinny implementować interfejs zawierający nazwę metody obliczającej powierzhnie. Czyli każda klasa pochodna posiada włąsną logikę obliczania pola i je nie zmieniamy np. do dając do systemu klasę Triangle
- L – LSP – Liskov substitution principle - w miejscu klasy bazowej możemy użyć dowolnej klasy, która po niej dziedziczy. Oznacza to, że klasa pochodna musi zachować 100% interfejsu klasy bazowej (wszystkie metody muszą przyjmować te same argumenty i zwracać te same typy). I np. w miejscu użycia klasy Figura moża podstawiać Kwadrat i Prostokąt i obliczać ich pole
- I – ISP – Interface segregation principle - nie powinno się wymuszać implementacji interfejsów które nie są używane. Innymi słowy: klienci nie powinni zależeć od interfejsów, których nie używają. Oznacza to, że lepiej zdefiniować wiele mniejszych interfejsów niż jeden wielki. Np. lepiej zdefinionwać interfejsy Walk Sleep Work i klasy Human i Android mogą implementować odpowiednie interfejsy
- D – DIP – Dependency inversion principle - moduły wysokopoziomowe nie powinny zależeć od modułów niskopoziomowych. Wszystkie zależności powinny w jak największym stopniu zależeć od abstrakcji, a nie od konkretnego typu. Czy np. w klasie PasswordReminder jako dbConnection nie powinniśmy używać konkretnego typu jak MySQlConnection ani PostgresSqlConnection tylko typ generyczny dbConnection
- https://blog.i-systems.pl/krotko-solid/

## 5. Naming cheat sheet

- https://github.com/kettanaito/naming-cheatsheet

## 5. Clean Code by R. C. Martin

# Names rules
- Choose descriptive and unambiguous names
- Make meaningful distinction
- Use pronounceable names
- Use searchable names
- Replace magic numbers with named constants
- Avoid encodings. Don't append prefixes or type information

