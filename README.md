# TechnoStudy | UI-Testautomatisierung

Ein Java-basiertes Lernprojekt zur automatisierten Prüfung der Benutzeroberfläche der öffentlich zugänglichen [TechnoStudy-Website](https://techno.study/).

Das Repository enthält Selenium-WebDriver-Tests für die Navigation auf der Website, ein Anmeldeformular, Blog-Links und Social-Media-Links. Für Testausführung und Testgruppen wird TestNG verwendet. Hilfsklassen unterstützen die Browserinitialisierung, Elementlokalisierung und Konfiguration.

**Projektstatus:** Lernprojekt in Entwicklung. Der Quellcode der automatisierten Tests ist vorhanden; ein vollständig erfolgreicher Testlauf wurde bislang nicht verifiziert.

## Verwendete Technologien

| Technologie | Version / Verwendung |
| --- | --- |
| Java | 21 |
| Selenium WebDriver | 4.51.0 – Browserautomatisierung |
| TestNG | 7.10.2 – Testannotationen, Gruppen, DataProvider und XML-Suites |
| Maven | Verwaltung von Abhängigkeiten und Build-Prozess |
| JUnit 4 | 4.13.2 – wird für eine Assertion in `TC02` verwendet |
| Log4j 2 | 2.26.1 – Logging in der Klasse `BaseDriver` |

In der `pom.xml` sind außerdem Apache Commons IO und `slf4j-nop` eingetragen. Das bedeutet nicht, dass jede dieser Bibliotheken aktiv in den Tests verwendet wird.

## Testszenarien

| Test | Geprüftes Szenario |
| --- | --- |
| TC01 | Öffnet Einträge im Menü „Programs“ und prüft, ob eine Seitenüberschrift angezeigt wird. |
| TC02 | Prüft die Weiterleitung von der Hauptwebsite zur Campus-Anmeldeseite. |
| TC03 | Testet das Anmelde-/Buchungsformular mit einem TestNG-`@DataProvider`, einschließlich gültiger und ungültiger Eingabekombinationen sowie Rückmeldungen des Formulars. |
| TC04 | Öffnet Blogbeiträge und prüft deren Ziel-URLs. |
| TC05 | Prüft die Links zu Facebook, Instagram, YouTube und LinkedIn im Footer. |
| TC07 | Prüft die Navigation über „Learn more“ mithilfe einer eigenen Page-Hilfsklasse. Die Implementierung benötigt derzeit Korrekturen. |
| TC08 | Öffnet das Anmeldeformular und klickt auf „Terms of Use“; eine abschließende Assertion ist noch nicht implementiert. |

Die Beschreibungen beziehen sich auf die derzeit im Quellcode implementierten Prüfungen, nicht auf nachgewiesene erfolgreiche Testläufe.

## Projektstruktur

Die Testklassen befinden sich unter `src/test/java` und sind nach Testszenarien organisiert.

Das Package `Utility` enthält folgende Klassen:

- `BaseDriver`
- `BaseDriverParameter`
- `ConfigReader`
- `Elements`
- `MyFunc`
- `WebTool`

In `Elements` werden Selenium-`PageFactory`-Locators verwendet.

Im Verzeichnis `Tests` befinden sich TestNG-XML-Suites für einzelne Szenarien sowie die kombinierte Suite `SmokeAndRegression.xml`.

## Projekt lokal ausführen

### Voraussetzungen

- Java JDK 21
- Apache Maven
- IntelliJ IDEA mit TestNG-Unterstützung
- Google Chrome oder Microsoft Edge

### 1. Repository klonen

`git clone https://github.com/ssewoesterlab/TechnoStudy_Project.git`

Anschließend in das Projektverzeichnis wechseln:

`cd TechnoStudy_Project`

### 2. Projekt importieren

Das Projekt in IntelliJ IDEA öffnen und die Maven-Abhängigkeiten neu laden.

### 3. TestNG-Suites ausführen

Das Verzeichnis `src/test/java/Tests/` öffnen, mit der rechten Maustaste auf `SmokeAndRegression.xml` klicken und **Run** auswählen.

Diese Suite enthält Konfigurationen für Chrome und Edge sowie die Gruppen `Smoke Test` und `Regression`.

**Hinweis:** `TC05` ist in der kombinierten Suite nicht enthalten.

### 4. Lokale Konfiguration

Der Test `TC03` verwendet `ConfigReader`. Diese Klasse erwartet derzeit die Datei:

`src/resources/config.properties`

Diese Datei ist nicht im Repository enthalten. Beispiel für eine lokale Konfiguration:

`baseUrl=https://techno.study/`

Vor dem Anlegen sollte `/src/resources/config.properties` in der `.gitignore` stehen. Zugangsdaten und andere vertrauliche Informationen dürfen nicht ins Repository eingecheckt werden.

## Bekannte Einschränkungen

- **Maven-Testausführung:** Die aktuelle Maven-Konfiguration enthält keine ausdrückliche Einstellung, die Klassen mit Namen wie `TC01.java` oder `TC02.java` bzw. eine TestNG-XML-Suite auswählt. Daher ist nicht nachgewiesen, dass `mvn test` alle Tests ausführt.
- **Lokale Konfiguration:** Der Formular-Test ist von einer Konfigurationsdatei abhängig, die nicht im Repository bereitgestellt wird.
- **TestNG-Parameter:** In `TC05.xml` wird der Parametername `BrowserType` verwendet, während das Browser-Setup `BrowserTipi` erwartet. Einige einzelne Suites müssen korrigiert werden.
- **Page-Hilfsklasse:** `TC07/TechnoStudyPage.java` initialisiert das `WebDriver`-Feld derzeit nicht im Konstruktor.
- **Assertions:** Einige Szenarien konzentrieren sich auf die Navigation und überprüfen das Ergebnis noch nicht ausreichend.

Die Tests greifen auf eine externe Website zu. Änderungen an Layout, Inhalten oder Element-Locators können Anpassungen der Tests erforderlich machen.

## Lernziele

Dieses Repository dokumentiert praktische Erfahrungen mit:

- Java-Programmierung
- Selenium WebDriver
- Testorganisation mit TestNG
- Datengetriebenen Testszenarien
- Browserautomatisierung und Assertions
- Wiederverwendbaren Hilfsklassen
- Abhängigkeitsverwaltung mit Maven
- Git und GitHub

Es handelt sich um ein Lern- und Portfolio-Projekt, nicht um ein produktionsreifes Testframework.