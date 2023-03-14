package com.semicolonafrica.mbmail.service;

import com.semicolonafrica.mbmail.data.dto.request.AddContactRequest;
import com.semicolonafrica.mbmail.data.model.Contact;

import java.util.Optional;

public interface ContactService {
    void addContact(Contact contact);
    Optional<Contact> findByEmailAddress(String emailAddress);
    boolean contactExist(String email);
}
