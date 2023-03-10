package com.semicolonafrica.mbmail.service;

import com.semicolonafrica.mbmail.data.dto.request.AddContactRequest;
import com.semicolonafrica.mbmail.data.model.Contact;
import com.semicolonafrica.mbmail.data.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepo contactRepo;
    @Override
    public void addContact(Contact contact) {
        contactRepo.save(contact);
    }
    @Override
    public Optional<Contact> findByEmailAddress(String emailAddress) {
        return contactRepo.findByEmailAddress(emailAddress);
    }
}
