  # Co-Working Space Applikation
  
  ## Einleitung

Dies ist eine Applikation, für `Mitglieder`, die sich online Co-Working Plätze und Räume Buchen wollen und `Administratoren`, die diese Buchungen und Mitglieder verwalten.  Ausserdem gibt es auch `Besucher`, die kein Konto haben und nur die Seite anschauen dürfen. Dies wird mit Quarkus entwickelt.

Hintergrund:
>Herr Joe Biden (no correlation) ist der Besitzer des Co-Working Space und es befindet sich in Zürich, wo der 80 Jährige Eis liebhaber Co-Working Spaces vermietet. 

## Benutzerrechte

Der `Administrator` hat folgende Aufgaben/Rechte:

+ Verwaltet Buchungsanfragen.
-- Akzeptieren
-- Ablehnen

+ Verwaltet bestehende Buchungen. 
-- Editieren 
-- Erstellen
-- Löschen

+ Verwaltet Mitglieder
-- Erstellen
-- Editieren
-- Löschen
-- Deaktivieren (dass das Mitglied keine Funktionen verwenden kann)

  - - - 

  Ein `Mitglied` hat folgende Rechte:
+ Ganze oder halbe Tage buchen
+ Für bestimmte Daten diese im voraus Buchen
+ Buchungsstatus mitverfolgen für Buchungsanfragen
+ Zukünftige Buchungen stornieren
+ Raum/Platz auswählen
+ Geräte ausleihen

- - -

Ein `Besucher` hat folgende Rechte:
+ Website anschauen
+ Konto erstellen um ein Mitglied zu werden

## Kontoerstellung

Wenn es noch keine Konten gibt, wird der erste erstellte User automatisch Administrator. 
Ein Besucher kann ein Konto erstellen, indem folgende Angaben gegeben werden:
- Vorname
- Nachname
- E-Mail
- Passwort

Administrator und Mitglieder können sich mit E-Mail und Passwort anmelden.

## Wichtige info

Auf keinen Fall dürfen Google-Fonts verwendet werden. Die sind nicht mehr DSGVO konform und könnten im Zukunft falls in ein EU Land ausgebaut wird zu schwierigkeiten führen.

Der Co-Working Space ist Sonntags geschlossen. Dann können auch keine Buchungen vorgenommer werden und Wartungen sollten auch dann statt finden.

Anfragen sollten nicht länger als 10 Sekunden dauern bevor ein Error angezeigt werden soll.
  
## Projekt einrichten

Im `Visual Studio Code` sollte man folgende Erweiterungen installieren:
- Dev Containers
- Remote Explorer
- IntelliCode
- Debugger for Java
- Maven for Java
- Project manager for Java
- Test runner for Java
- Quarkus
- Tools for Microprofile

Quarkus soll dann korrekt installiert werden.

Mit F1 kann man die Kommandozeile für VSC öffnen und dort auswählen `reopen Project in Container`
###
Das Projekt kann gestartet werden, wenn man ein Terminal öffnet und dort folgenden Befehl schreibt: 
 <code>./mvnw compile quarkus:dev</code> 

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Erste Schritte

1. Erstelle eine Kopie (fork) von diesem Projekt.
1. Stelle sicher, dass Docker installiert ist und läuft.
1. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
1. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
1. Öffne das Projekt mit Visual Studio Code.
1. Öffne das Projekt im Entwicklungscontainer.
1. Starte das Projekt mit dem Kommando `Quarkus: Debug current Quarkus Project`
1. Probiere die Client-Applikation unter http://localhost:8080 aus.
1. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.

## Automatische Tests
Die Testdaten und Tests sind im `src/test/java/ch/zli/m223/`

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Funktion implementierung

- [X] User erstellen
- [X] User bearbeiten
- [X] User löschen
- [X] Erste User ist ein Administrator
- [X] User werden in JSON gespeicher
- [X] Testfälle für User funktionen
- [ ] Räume/Plätze buchen
- [ ] Buchungsanfragen ablehnen oder akzeptieren
- [ ] Ganze oder halbe Tage buchen können
- [ ] JW Tokens werden erstellt.
- [ ] Nach 10 sekunden ohne Abfragebestätigung wird ein Error zurück gegeben.
- [ ] Tests für die weiteren Funktionen


