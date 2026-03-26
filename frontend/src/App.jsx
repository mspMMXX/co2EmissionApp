import { useState } from "react";
import "./App.css";

/**
 * Zentrale React-Komponente der Anwendung.
 *
 * Stellt die Benutzeroberfläche für:
 * - Registrierung
 * - Login
 * - Suche nach Emissionsdaten
 * - Speichern/Aktualisieren von Emissionsdaten
 * bereit.
 */
function App() {
  // Zustände für Registrierung
  const [registerUsername, setRegisterUsername] = useState("");
  const [registerPassword, setRegisterPassword] = useState("");

  // Zustände für Login
  const [loginUsername, setLoginUsername] = useState("");
  const [loginPassword, setLoginPassword] = useState("");

  // Zustände für Suche und Emissionsdaten
  const [searchCountry, setSearchCountry] = useState("");
  const [country, setCountry] = useState("");
  const [year, setYear] = useState("");
  const [co2Emission, setCo2Emission] = useState("");

  // Statusmeldung und Ergebnisanzeige
  const [message, setMessage] = useState("");
  const [emissionResult, setEmissionResult] = useState(null);

  /**
   * Sendet Registrierungsdaten an das Backend
   * und legt einen neuen Benutzer an.
   */
  const handleRegister = async () => {
    try {
      const response = await fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          username: registerUsername,
          password: registerPassword
        })
      });

      const data = await response.json();
      setMessage(`Registriert: ${data.username}`);
    } catch (error) {
      setMessage("Fehler bei der Registrierung");
    }
  };

  /**
   * Führt einen einfachen Login gegen das Backend aus.
   * Das Ergebnis wird als Textmeldung angezeigt.
   */
  const handleLogin = async () => {
    try {
      const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          username: loginUsername,
          password: loginPassword
        })
      });

      const text = await response.text();
      setMessage(text);
    } catch (error) {
      setMessage("Fehler beim Login");
    }
  };

  /**
   * Ruft den aktuell gespeicherten Emissionsdatensatz
   * für ein bestimmtes Land ab.
   */
  const handleSearch = async () => {
    try {
      const response = await fetch(`http://localhost:8080/emissions/${searchCountry}`);
      const data = await response.json();
      setEmissionResult(data);
      setMessage("Datensatz gefunden");
    } catch (error) {
      setMessage("Fehler bei der Suche");
      setEmissionResult(null);
    }
  };

  /**
   * Speichert einen neuen Emissionsdatensatz oder überschreibt
   * den bestehenden Datensatz eines Landes.
   *
   * Als Benutzername wird der aktuell im Login-Feld eingetragene
   * Benutzer verwendet.
   */
  const handleSaveEmission = async () => {
    try {
      const response = await fetch("http://localhost:8080/emissions", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          country,
          year: Number(year),
          co2Emission: Number(co2Emission),
          username: loginUsername
        })
      });

      const data = await response.json();
      setEmissionResult(data);
      setMessage("Emissionsdaten gespeichert");
    } catch (error) {
      setMessage("Fehler beim Speichern");
    }
  };

  return (
    <div className="container">
      <h1>CO2 Emission App</h1>

      <section className="card">
        <h2>Registrierung</h2>
        <input
          type="text"
          placeholder="Username"
          value={registerUsername}
          onChange={(e) => setRegisterUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Passwort"
          value={registerPassword}
          onChange={(e) => setRegisterPassword(e.target.value)}
        />
        <button onClick={handleRegister}>Registrieren</button>
      </section>

      <section className="card">
        <h2>Login</h2>
        <input
          type="text"
          placeholder="Username"
          value={loginUsername}
          onChange={(e) => setLoginUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Passwort"
          value={loginPassword}
          onChange={(e) => setLoginPassword(e.target.value)}
        />
        <button onClick={handleLogin}>Login</button>
      </section>

      <section className="card">
        <h2>CO2-Wert suchen</h2>
        <input
          type="text"
          placeholder="Land eingeben"
          value={searchCountry}
          onChange={(e) => setSearchCountry(e.target.value)}
        />
        <button onClick={handleSearch}>Suchen</button>
      </section>

      <section className="card">
        <h2>CO2-Wert speichern / aktualisieren</h2>
        <input
          type="text"
          placeholder="Land"
          value={country}
          onChange={(e) => setCountry(e.target.value)}
        />
        <input
          type="number"
          placeholder="Jahr"
          value={year}
          onChange={(e) => setYear(e.target.value)}
        />
        <input
          type="number"
          step="0.01"
          placeholder="CO2-Emission"
          value={co2Emission}
          onChange={(e) => setCo2Emission(e.target.value)}
        />
        <button onClick={handleSaveEmission}>Speichern</button>
      </section>

      <section className="card">
        <h2>Status</h2>
        <p>{message}</p>
      </section>

      {emissionResult && (
        <section className="card">
          <h2>Gefundener Datensatz</h2>
          <p><strong>Land:</strong> {emissionResult.country}</p>
          <p><strong>Jahr:</strong> {emissionResult.year}</p>
          <p><strong>CO2-Emission:</strong> {emissionResult.co2Emission}</p>
          {emissionResult.createdBy && (
            <p><strong>Erstellt von:</strong> {emissionResult.createdBy.username}</p>
          )}
        </section>
      )}
    </div>
  );
}

export default App;