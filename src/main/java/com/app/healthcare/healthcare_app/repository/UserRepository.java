package com.app.healthcare.healthcare_app.repository;

import com.app.healthcare.healthcare_app.model.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<JwtUser, Long> {

    Optional<JwtUser> findByUsername(String username);

}