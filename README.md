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
- używajmy dobrze nazwanych stałych
- używając dobrze nazwanych stałych sprawiamy, że kod staje się czytelniejszy
- kod powinien być łatwo czytelny jak książka, więcej czasu czytamy kod niż go piszemy
- uczcąc się pisania czystego kodu można robić lepsze code review
- należy budować nawyk refaktoryzacji, czyli np. zmiana nazwy
- aby pisać czysty kod należy poznać fundamenty: hermetyzacja, zasady solid, grasp
- zamieniamy BigDecimal na ValueObjecty
  np. zamiast dt - currentDate zamiast execute - generateRaport
- obsługa wyjątków: jeśli blok try {} jest mocno rozbudowany to warto go wynieść do metody tak aby był bardziej zrozumiały, nazwa metody też będzie pomocna w zrozumieniu kodu
- małe metody można próbować zmieścić w jednej linii, np. w 1 jednym warunku
- obliczanie zmiennych lokalnych można wynosić do innych metod, dzięki temu można te metody wykorzystać w innych miejscach i metody będą prostrze
- zmienna lokalna powinna być final to znaczy, że ma dobrze zdefiniowany 1 cel

- przekazywanie danych do metody poprzez długą listę parametrów jest raczej mało czytelne. Takie listy są też często mylące. 
Parametry, które można wyliczyć z innych parametrów, warto wyliczyć właśnie na ich podstawie.
Można wprowadzić obiekt parametryczny. Jeśli kilka danych występuje razem i są spójne ze sobą.    
Przekazać cały obiekt.
Jeżeli powyższe punkty nie są dobrymi opcjami to możemy zastąpić wywołanie metody wywołaniem metody obiektu. Jest to fajna praktyka, która często sprawia, że kod staje się czytelniejszy. 
W skrócie, chodzi o to, aby stworzyć nowy obiekt i tam przenieść tą metodę. Parametry, które możemy to podajemy w konstruktorze obiektu. 
Dodatkowo możemy sobie w konstruktorze odpowiednio te dane przygotować tak, aby uprościć korzystanie z tych danych w przeniesionej metodzie.
Później takie wywołanie mogłoby wyglądać:
new Scorer(name, counter).execute(score);
Można w takiej klasie umieścić klika metod mających wspólne parametry.
- w hermetyzacji chcemy pilnować tego, aby jak najmniej informacji wychodziło na zewnątrz, tylko to co najpotrzebniejsze. 
Ale to gdzie ten obiekt będzie używany to już nie jest ważne, bo ma określony interfejs i z niego możemy korzystać. 
Dzięki temu, ze mamy to ukryte to mozemy łatwo zmieniać implementacje plus działania na tym obiekcie są bezpieczne, bo nie mozemy wprowadzić naszego obiektu w zły stan plus logika jest w jednym miejscu.
Natomiast chcemy dążyć do jak najmniejszego couplingu czyli do jak najmniejszej ilości powiązań.
Lepiej przekazać jeden parametr niż cały obiekt, ale jeżeli korzystamy już z wielu danych z tego obiektu to lepiej przekazać cały obiekt, bo wtedy raczej będzie kod czytelniejszy.
Jeszcze możemy się zastanowić czy to co robimy z tymi danymi w tej metodzie możemy wydelegować do tego obiektu. Wtedy zwiększylibyśmy hermetyzację.

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

### Wzorce GRASP
- ułatwiatja przydzielanie zadań do klas

#### Creator
- kto jest odpowiedzialny za tworzenie obiektów
- jest częścią
- blisko współpracuje
- ma potrzebne dane

#### Information Expert
- która klasa posiada najwięcej informacji do wykonania zadania
- np. ceny pojedyńczych produktów powinny być obliczane w SigleItem, Single item ma niezbędne iformacje, umieszczamy obliczenia tam gdzie mamy najwięcej informacji bazowych i pozbywamy się połączeń z niewspółpracujących klas

#### Low Coupling
- dążymy do lużnych powiązań, wystawiamy interfejsy (hermetyzacja) 
- zmniejszamy ilość powiązań
- duży coupling zmian powoduje, że jedna zmiana w danej klasie powoduje wiele zmian w innych klasach
- klasy są trudniesze do zrozumienia
- zmniejsza się możliwość dowolnego wykorzystania
- klasy powinny porozumiewać się przez abstrakcję
- brak abstrakcji powoduje, że ewentualne zmiany muszą wystąpić w wielu miejscach czyli mogą wystąpić błędy 
Podział couplingu
- Tight coupling - mocny coupling, czyli jedna klasa ma dużo powiązań z drugą klasą
- Light coupling - powiązanie klas za pomocą abstrakcji, użycie interfejsów, hermetyzacji, ukrywanie szczegółów implementacyjnych za konkretnym api 
Rodzaje couuplingu
1. Contentent coupling - jedna klasa manipuluje wnętrzem klasy drugiej klasy (klasa Customer manipuluje wartościami klasy Store)
2. Common coupling - wykorzystanie wspólnie jakiegoś globalnego stanu, zmiana stanu może powodować błędy
3. External coupling - struktura klasy nie powinna zależeć od zenętrznych struktur np. odbieranie wiadomości
4. Control coupling - jedna klasa narzuca drugiej to co ma być zrobione np. activate(true) na activate as premium
5. Stamp coupling - metoda np. przyjmuje parametr całą klasę User a używa tylko z tego obiektu 2 wartości
6. Data coupling - przekazujemy do metod tylko porządane parametry

Im mniejszy coupling tym lepiej. 
# Metody

Metody nie powinny mieć skutków ubocznych - tzn. metoda powinna być odpowiedzailna za 1 zadanie a przynajmiej mówić w nazwie co robi. Nie powiązane kroki prepareOrder, sendStatus najlepiej wykonywać w ogólnej metodzie. A w mniejszych metodach wykonać te właśnie 2 kroki.
Należy unikać metod, które zwracają argumenty. Np calculateDiscount(rate, product) - nie wiemy co się dzieje w środku z produktem. Lepiej jest zrobić addDiscount(product). Czyli metoda z opowiednią nazwą i argumentem musi od razu zostać zrozumiana bez zagłębiania się w metodzie. Lub dla większej widoczności możemy zwrócić z metody listę zmienionych obiektów: List<Orders> orders = cancelOrders(filteredOrders). Lub warto rozbijać funkcjonalność metody np. wykonać określoną okację na liście a później inną akcję na konkretnym obiekcie.
Metody powinny mieć jak najmniej argumentów, jeśly jedynym argumentem jest obiekt to metoda powinna zostać dodana do obiektu. A jeśli metoda ma 2 argumenty to można dodać metodę do 1 argumentu (obiektu) mającą pozostały 1 argument. Jeśli metoda ma więcej niż kilka argumentów to pewnie można stworzyć z niej obiekt. Można łączyć ciała metod w 1 ogólną metodę.


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
- 

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


## 5. Jak pisać czysty kod?

Należy sobie uświadomić, że nie ma idealnego kodu. Kod może być co najwyżej najczystszy i najlepszy, jaki mógł zostać wykonany w danym momencie. Napisanie takiego kodu wymaga umiejętności zdobytej poprzez ciężką pracę i praktykę bazując na wiedzy z dziedziny programowania, znajomości zasad, wzorców i heurystyk clean code’u.

# 1. Opisowe nazwy
Nazwy zmiennych, metod i klas powinny być opisowe, powinny przedstawiać intencje, informować, w jakim celu istnieją, co robią, jak są używane.
Wyniesienie magicznych liczb do stałych i wprowadzenie odpowiednich nazw klasy, pola i metody znacząco poprawia czytelność. Przykładowe rozwiązanie:

# 2. Nazwy na odpowiednim poziomie abstrakcji
Nazwy mogą być opisowe, jednak mogą mówić za mało, lub za dużo na konkretnym poziomie abstrakcji. Przykładowo:

# 3. Nazwy powinny opisywać efekty uboczne
Nazwa powinna opisywać, co wykonuje dana metoda, zmienna lub klasa. Przykładowo, jeżeli funkcja wyszukuje jakiś obiekt a w przypadku kiedy go nie znajdzie tworzy nowy to lepiej użyć nazwy findOrCreate zamiast tylko find.

# 4. Komentarze nie powinny istnieć
Pisanie komentarzy w kodzie przeważnie spowodowane jest tym, że nazwy zmiennych, metod i klas są nieczytelne lub niepoprawne. Zamiast je tworzyć, lepiej poświęć czas na wyborze odpowiednich nazw. Jeśli napisanie komentarza jest rzeczywiście uzasadnione, to trzeba napisać go dobrze. Powinien być zwięzły, gramatycznie poprawny z uważnie dobranymi słowami.

# 5. Zakomentowany kod powinien być usunięty
Zakomentowany kod rodzi sporo pytań czytelnika, w ogólności zanieczyszcza cały kod i przeszkadza w czytaniu. Im dłużej istnieje, tym bardziej się psuje i traci na znaczeniu. Dodatkowo możliwe, że nikt go nie skasuje, bo nie będzie wiedział, czy jest on znaczący, czy nie, czy ktoś go potrzebuje, czy ma wobec niego jakieś plany. Zakomentowany kod powinien być zawsze usuwany.

6. Formatowanie kodu zgodnie z zasadami zespołowymi
Pracując w zespole, nie należy stosować własnych ulubionych zasad formatowania. To zespól programistów ustala jeden styl formatowania i każdy powinien się do niego dostosować. Kod musi być spójny, musi budzić zaufanie czytelnika, który uzna, że formatowanie w jednym pliku źródłowym oznacza to samo w innym.

7. Funkcje powinny być małe wykonując jedną czynność
Wielkość funkcji można zmierzyć po ilości wierszy, z których jest zbudowana. Im więcej wierszy tym funkcja bardziej nieczytelna i trudniej zrozumieć jej działanie. Małe funkcje to te, które skonstruowane są maksymalnie z 20 wierszy wykonując tylko jedną operację. Jeśli wierszy jest więcej, to prawdopodobnie funkcja wykonuje więcej czynności.

8. Jak najmniejsza liczba argumentów funkcji
Argumenty funkcji są kłopotliwe i utrudniają zrozumienie funkcji. Najlepiej konstruować funkcje bezargumentowe, później jednoargumentowe i dwuargumentowe. Funkcji trzyargumentowych należy unikać, a funkcje wieloargumentowe (więcej niż 3 argumenty) nie powinny być stosowane. Przykładowo funkcja writeText(text) jest łatwiejsza w zrozumieniu niż writeText(outputStream, text). W tej sytuacji argumentu outputStream można się pozbyć definiując je jako pole klasy. Gdy funkcja wymaga wiele argumentów, to prawdopodobnie niektóre z nich można umieścić w osobnej klasie. 

9. Funkcje nie powinny zwracać null
Zwracanie wartości null tworzy dodatkową pracę i powoduje problemy w funkcjach wywołujących. W takich przypadkach przez brak sprawdzenia wartości null traci się kontrolę nad aplikacją. Pojawiają się wyjątki NullPointerException, które w najmniej oczekiwanym czasie przerywają działanie programu. 

10. Rozdzielanie poleceń i zapytań
Funkcja powinna wykonywać jakieś polecenie lub odpowiadać na jakieś pytanie. Nie powinna robić tych dwóch operacji jednocześnie, ponieważ często prowadzi to do pomyłek. 

11. Zasada DRY (Don’t repeat yourself)
Reguła DRY zaleca unikanie różnego rodzaju powtórzeń wykonywanych przez programistów podczas wytwarzania oprogramowania. Odnosząc się do kodu, chodzi o niewklejanie, lub niepisanie tych samych, lub bardzo podobnych fragmentów kodu w różnych miejscach. Takie powielanie kodu powoduje jego wzrost, wymaga tych samych modyfikacji w kilku miejscach w przypadku jakichkolwiek zmian algorytmu, a to z kolei zwiększa możliwość popełnienia błędu.
Najprostsze rozwiązanie na zduplikowany kod to wyniesienie go do osobnej metody. W niektórych przypadkach pomaga zastosowanie polimorfizmu lub wzorców projektowych jak np. szablon metody, lub strategia.

12. Obsługa błędów powinna być jedną operacją
Obsługa błędów jest jedną operacją i zgodnie z zasadą pojedynczej odpowiedzialności funkcja obsługi błędów nie powinna wykonywać nic innego. Oznacza to, że słowo kluczowe try powinno być pierwszym słowem w funkcji i nie powinno się w niej znajdować nic oprócz catch i finally.

13. Klasy powinny mieć jedną odpowiedzialność
Zgodnie z zasadą pojedynczej odpowiedzialności (SRP), klasa powinna mieć tylko jeden powód do zmiany. Jeżeli klasa jest odpowiedzialna za więcej niż jeden obszar w naszej aplikacji, to może powodować to problemy w przyszłości tzn. robiąc zmiany w jednym obszarze, można zepsuć coś w innym obszarze, który wydaje się niepowiązany.

14. Hermetyzacja – zmienne i funkcje użytkowe pozostają prywatne
Najczęściej zmienne i funkcje użytkowe w klasach powinny być prywatne. Takie ukrywanie dostępność dla innych klas sprawia, że refaktoryzacja jest bezpieczniejsza a zmiana stanu obiektu w pełni kontrolowana. Czasami zmiennym, lub funkcjom zmienia się zasięg na chroniony lub dostępny w ramach pakietu. Jest to głównie wymuszone przez testy, w sytuacji kiedy test potrzebuje wywołać taką funkcję, lub odnieść się do zmiennej. Należy jednak w pierwszej kolejności szukać sposobu na zachowanie prywatności.

15. Spójność klasy powinna być wysoka
Klasa, w której każda zmienna instancyjna jest wykorzystywana w każdej metodzie, jest maksymalnie spójna. Zwykle nie jest możliwe tworzenie takich klas, ale należy dążyć do tego, aby spójność była wysoka. Dzięki temu metody i zmienne klasy są wzajemnie zależne i tworzą logiczną całość.

Przy stosowaniu małych funkcji z małą liczbą parametrów często można zaobserwować, że niektóre zmienne instancyjne używane są tylko przez podzbiór metod. W tym przypadku oznacza to, że w takiej klasie istnieje inna klasa, która powinna być od niej uwolniona. Dzięki temu powstałe klasy będą bardziej spójne.

Podsumowanie

Wybór opisowych nazw klas, funkcji i zmiennych
Nazwy powinny być na odpowiednim poziomie abstrakcji
Nazwy powinny opisywać efekty uboczne
Nie należy stosować komentarzy. Kod powinien być samo opisujący się
Zakomentowany kod powinien być usunięty
Formatowanie kodu powinno być zgodne z zasadami przyjętymi w zespole
Funkcje powinny być małe wykonując jedną czynność
Funkcje powinny przyjmować maksymalnie 3 argumenty. Im mniej, tym lepiej
Funkcje nie powinny zwracać null
Funkcje powinny wykonywać albo jakieś polecenie, albo odpowiadać na jakieś pytanie
Stosowanie zasady DRY
Obsługa błędów powinna być jedną operacją
Klasy powinny mieć jedną odpowiedzialność
Zmienne i funkcje użytkowe powinny być prywatne
Spójność klasy powinna być wysoka
Kod powinien być pokryty testami jednostkowymi
Programowanie obiektowe powinno spełniać założenia SOLID

## 6. Naming cheat sheet

- https://github.com/kettanaito/naming-cheatsheet

# What is clean code?
Clean code is not a set of strict rules. It is a set of principles for writing code that is easy to understand and modify. In this case, “understandable” means that the code can be immediately understood by any experienced developer. The following characteristics of clean code are what make it easy to read:

The entire application’s order of execution is logical and clearly structured.
The connection between different parts of the code is quite obvious.
The task or role of each class, function, method, and variable is immediately understandable.
Code is easy to modify if it can be adapted and extended. This also makes it easier to correct errors in the code. Clean code is thus very easy to maintain. Easily modifiable code has the following characteristics:

Classes and methods are small and only have one single task.
Classes and methods are predictable, work as expected, and are publicly available through well-documented APIs (interfaces).
The code uses unit tests.
The advantages of this kind of programming are obvious. Clean code does not depend on the original developer. In principle, any programmer can work with the code. This prevents problems that may occur when working with legacy code, for example. It is also easier to maintain the code because bugs can be identified and fixed more easily.

# Tips and Conventions to Write Cleaner Code
Effectiveness, Efficiency and Simplicity
Whenever I need to think about how to implement a new feature into an already existing codebase, or how to tackle the solution of a specific problem, I always prioritize this three simple things.

Effectiveness
First, our code should be effective, meaning it should solve the problem it's supposed to solve. Of course this is the most basic expectation we could have for our code, but if our implementation doesn't actually work, it's worthless to think about any other thing.

Efficiency
Second, once we know our code solves the problem, we should check if it does so efficiently. Does the program run using a reasonable amount of resources in terms of time and space? Can it run faster and with less space?

## 7. Clean Code by R. C. Martin 

@Source https://gist.github.com/wojteklu/


# Names rules

- Choose descriptive and unambiguous names
- Make meaningful distinction
- Use pronounceable names
- Use searchable names
- Replace magic numbers with named constants
- Avoid encodings. Don't append prefixes or type information

# General rules
- Follow standard conventions.
- Keep it simple stupid. Simpler is always better. Reduce complexity as much as possible.
- Boy scout rule. Leave the campground cleaner than you found it.

# Functions rules

- Small.
- Do one thing.
- Use descriptive names.
- Prefer fewer arguments.
- Have no side effects.
- Don't use flag arguments. Split method into several independent methods that can be called from the client without the flag.


# Comments rules

- Always try to explain yourself in code.
- Don't be redundant.
- Don't add obvious noise.
- Don't use closing brace comments.
- Don't comment out code. Just remove.
- Use as explanation of intent.
- Use as clarification of code.
- Use as warning of consequences.

# Design rules
- Keep configurable data at high levels.
- Prefer polymorphism to if/else or switch/case.
- Separate multi-threading code.
- Prevent over-configurability.
- Use dependency injection.
- Follow Law of Demeter. A class should know only its direct dependencies.

# Source code structure

- Separate concepts vertically.
- Related code should appear vertically dense.
- Declare variables close to their usage.
- Dependent functions should be close.
- Similar functions should be close.
- Place functions in the downward direction.
- Keep lines short.
- Don't use horizontal alignment.
- Use white space to associate related things and disassociate weakly related.
- Don't break indentation.

# Objects and data structures
- Hide internal structure.
- Prefer data structures.
- Avoid hybrids structures (half object and half data).
- Should be small.
- Do one thing.
- Small number of instance variables.
- Base class should know nothing about their derivatives.
- Better to have many functions than to pass some code into a function to select a behavior.
- Prefer non-static methods to static methods.

# Objects and data structures
- Hide internal structure.
- Prefer data structures.
- Avoid hybrids structures (half object and half data).
- Should be small.
- Do one thing.
- Small number of instance variables.
- Base class should know nothing about their derivatives.
- Better to have many functions than to pass some code into a function to select a behavior.
- Prefer non-static methods to static methods.

# Tests
- One assert per test.
- Readable.
- Fast.
- Independent.
- Repeatable.

# Code smells
- Rigidity. The software is difficult to change. A small change causes a cascade of subsequent changes.
- Fragility. The software breaks in many places due to a single change.
- Immobility. You cannot reuse parts of the code in other projects because of involved risks and high effort.
- Needless Complexity.
- Needless Repetition.
- Opacity. The code is hard to understand.

# Understandability tips
- Be consistent. If you do something a certain way, do all similar things in the same way.
- Use explanatory variables.
- Encapsulate boundary conditions. Boundary conditions are hard to keep track of. Put the processing for them in one place.
- Prefer dedicated value objects to primitive type.
- Avoid logical dependency. Don't write methods which works correctly depending on something else in the same class.
- Avoid negative conditionals.

# General rules
- Follow standard conventions.
- Keep it simple stupid. Simpler is always better. Reduce complexity as much as possible.
- Boy scout rule. Leave the campground cleaner than you found it.
- Always find root cause. Always look for the root cause of a problem.



# 10 steps to writing clean code
Here are a few ways you can ensure your code comes out clean:

* Follow conventions
Using a naming convention is a great way to get started — it keeps things clear and lets you know exactly what you’re working with. 
A naming convention basically means you decide you’ll call your variables by names that adhere to a certain set of rules. It can get hairy, and a lot of people don’t always agree on which is best. So to keep it simple. It can be something as simple as prefixing variable names with their data type,

Indicate variable scope
Say what you mean
Whitespace is nice space
Commenting saves lives
Automate to save time and space
Remember the power of i
Birds of a feather group similar variables together
Keep it functional
Keep it classy





