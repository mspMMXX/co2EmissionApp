package com.msp.co2app.repository;

import com.msp.co2app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository für den Zugriff auf Benutzerdaten.
 * 
 * Erbt von JpaRepository und stellt dadurch automatisch
 * grundlegende CRUD-Operationen (Speichern, Finden, Löschen) bereit.
 */
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    /**
     * Sucht einen Benutzer anhand seines Usernames.
     * 
     * Die Implementierung wird automatisch von Spring Data JPA generiert
     * basierend auf dem Methodennamen.
     */
    AppUser findByUsername(String username);

    /**
     * Prüft, ob ein Benutzer mit dem angegebenen Username existiert.
     * 
     * Wird z. B. verwendet, um doppelte Registrierungen zu vermeiden.
     */
    boolean existsByUsername(String username);
}