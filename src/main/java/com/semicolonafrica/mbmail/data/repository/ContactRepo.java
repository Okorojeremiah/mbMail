package com.semicolonafrica.mbmail.data.repository;

import com.semicolonafrica.mbmail.data.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ContactRepo extends JpaRepository<Contact, Long> {
    Optional<Contact> findByEmailAddress(String emailAddress);
}
