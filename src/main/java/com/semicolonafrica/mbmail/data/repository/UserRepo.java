package com.semicolonafrica.mbmail.data.repository;

import com.semicolonafrica.mbmail.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmailAddress(String emailAddress);
}
