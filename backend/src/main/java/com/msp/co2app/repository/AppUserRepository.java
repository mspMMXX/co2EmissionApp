package com.msp.co2app.repository;

import com.msp.co2app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByUsername(String username);

    boolean existsByUsername(String username);
}