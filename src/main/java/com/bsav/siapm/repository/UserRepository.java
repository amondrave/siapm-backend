package com.bsav.siapm.repository;

import com.bsav.siapm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {

    Optional<User> findByDocument(String document);

    Boolean existsByDocument(String document);

    Boolean existsByEmail(String email);
}
