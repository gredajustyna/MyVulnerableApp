# MyVulnerableApp
 Niezabezpieczona aplikacja na platformę Android do badania podatności i zagrożeń.
 W celu uruchomienia aplikacji należy zainstalować na komputerze środowisko Android Studio. Najlepiej wykonać to na początku demonstracji. 
 
 ### Zrzuty ekranu z aplikacji:
 <p align = "middle">
 <img src = "https://user-images.githubusercontent.com/83274413/142742998-04bff14a-a3f8-4e90-a70b-b1c42a2f198f.png" width="225"/>
 <img src = "https://user-images.githubusercontent.com/83274413/142743018-6c78f61c-faa1-4daf-a3ae-8459cccefed9.png" width="225"/>
 <img src = "https://user-images.githubusercontent.com/83274413/142743041-c6cc9c7b-0c5d-4a8a-b4b3-1f9129da960c.png" width="225"/>
</p>

### Zadania:
#### Zadanie 1 - Błąd zmęczonego programisty:
Ważne jest, aby w aplikacji, która korzysta z loginów użytkowników nie dało się zarejestrować dwóch osób o takiej samej nazwie użytkownika. Chociaż w przypadku MyVulnerableApp użytkowników rozróżnia się po unikalnym id, warto dodać funkcjonalność, która zablokuje zarejestrowanie dwóch takich samych nazw użytkownika. Osoba pisząca MyVulnerableApp o to zadbała, jednak w trakcie implementacji nieco się zmęczyła i popełniła błąd. Proszę znaleźć go i poprawić tak, aby działało rozróżnianie użytkowników także po ich nazwie.
 
#### Zadanie 2 - Ale to ty dzwonisz:
W polu na numer telefonu powinien się znajdować wyłącznie numer telefonu, przecież można potem na niego nawet zadzwonić. Atrybut inputType w pliku xml zadbał o to, aby można było wpisywać w pole 'Phone number' tylko niektóre znaki. To jednak za mało, żeby w pełni zabezpieczyć to pole przed niewłaściwymi danymi wejściowymi. Proszę odkryć podatność i ją zabezpieczyć. Ponadto, informacja o nieodpowiednich danych wejściowych powinna wyświetlić się użytkownikowi na ekranie.

#### Zadanie 3 - Ciemność, widzę ciemność:
Czasem już tak bywa, że człowiekowi się nic nie chce - nawet wpisać danych w pole z danymi wejściowymi. Trochę ciężko zadzwonić pod żaden numer telefonu, czy skontaktować się z nikim. Proszę o załatanie tej luki, należy szczególnie zwrócić uwagę na pole z numerem telefonu. Ponadto, informacja o braku danych wejściowych powinna wyświetlić się użytkownikowi na ekranie.


