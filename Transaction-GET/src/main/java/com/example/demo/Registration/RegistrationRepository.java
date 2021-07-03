package com.example.demo.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    @Query("SELECT r FROM Registration r WHERE r.UserName = ?1")
    Registration findByUserName(String UserName);

    @Query("SELECT r FROM Registration r WHERE r.UserName = ?1 AND r.Password = ?2")
    Registration findByUserNameAndPassword(String UserName, String Password);
}
