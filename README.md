# CO2 Emission App

## Projektbeschreibung
Die CO2 Emission App ist ein Prototyp einer Webanwendung zur Anzeige und Verwaltung von CO2-Emissionsdaten einzelner Länder.

Die Anwendung bietet:
	•	öffentliche Suche nach dem aktuell gespeicherten CO2-Wert eines Landes
	•	Registrierung und Login für Benutzer
	•	Hinzufügen bzw. Aktualisieren von Emissionsdaten

Pro Land wird jeweils nur ein aktueller Datensatz gespeichert. Neue Eingaben überschreiben bestehende Werte.

# Verwendete Technologien

## Backend
	•	Java
	•	Spring Boot
	•	Spring Data JPA
	•	Hibernate
	•	MySQL

## Frontend
	•	React
	•	Vite
	•	JavaScript
	•	CSS

## Weitere Tools
	•	Docker
	•	DBeaver
	•	VS Code

# Voraussetzungen

Folgende Software muss installiert sein:
	•	Java 17 oder höher
	•	Node.js / npm
	•	Docker
	•	Git

# Datenbank mit Docker starten

Die MySQL-Datenbank wird über Docker Compose bereitgestellt und enthält bereits initiale Daten.

## Starten der Datenbank

Im Projektverzeichnis ausführen:

docker compose up -d

Beim ersten Start wird die Datenbank automatisch mit den enthaltenen CO2-Daten befüllt.

## Stoppen der Datenbank

docker compose down

Um die Datenbank vollständig zurückzusetzen (inkl. aller Daten):

docker compose down -v
docker compose up -d

Hinweis:
Die Initialisierung der Datenbank erfolgt über die Datei:

database/init.sql

Diese wird automatisch beim ersten Start ausgeführt.

## Datenbankkonfiguration

Die Verbindung wird im Backend in folgender Datei definiert:

backend/src/main/resources/application.properties

Beispiel:

spring.datasource.url=jdbc:mysql://localhost:3306/co2db
spring.datasource.username=co2user
spring.datasource.password=co2pass

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## Backend starten

cd backend
./mvnw spring-boot:run

Alternativ kann das Backend direkt über VS Code gestartet werden.

Das Backend läuft standardmäßig auf:

http://localhost:8080

## Frontend starten

cd frontend
npm install
npm run dev

Das Frontend ist danach erreichbar unter:

http://localhost:5173

# Testen der Anwendung
	1.	Über das Frontend

Folgende Funktionen können getestet werden:
	•	Benutzer registrieren
	•	Benutzer einloggen
	•	Emissionsdaten eines Landes abrufen
	•	Emissionsdaten speichern oder aktualisieren
        - Um Daten zu speichern oder zu aktualisieren muss man sich vorher registrieren und anmelden

	2.	Über REST-Requests

Im Backend befindet sich eine Datei:

test/test.http

Diese kann mit der VS Code REST Client Extension verwendet werden.

Beispiel-Endpunkte:
	•	POST /auth/register
	•	POST /auth/login
	•	POST /emissions
	•	GET /emissions/{country}

# Beispielablauf
	1.	Docker-Container starten
	2.	Backend starten
	3.	Frontend starten
	4.	Benutzer registrieren
	5.	Benutzer einloggen
	6.	Emissionsdaten für ein Land speichern
	7.	Emissionsdaten über die Suche abrufen

Hinweise
	•	Pro Land wird nur ein Datensatz gespeichert
	•	Neue Werte überschreiben bestehende Einträge
	•	Die Anwendung ist als Prototyp umgesetzt
	•	Passwörter werden aktuell unverschlüsselt gespeichert (zu Demonstrationszwecken)

Autor

Markus Platter