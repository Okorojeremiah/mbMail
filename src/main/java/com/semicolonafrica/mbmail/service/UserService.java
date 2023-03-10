package com.semicolonafrica.mbmail.service;

import com.semicolonafrica.mbmail.data.dto.request.AddContactRequest;
import com.semicolonafrica.mbmail.data.dto.request.LoginRequest;
import com.semicolonafrica.mbmail.data.dto.request.MessageRequest;
import com.semicolonafrica.mbmail.data.dto.request.RegistrationRequest;
import com.semicolonafrica.mbmail.data.dto.response.AddContactResponse;
import com.semicolonafrica.mbmail.data.dto.response.LoginResponse;
import com.semicolonafrica.mbmail.data.dto.response.MessageResponse;
import com.semicolonafrica.mbmail.data.dto.response.RegistrationResponse;
import com.semicolonafrica.mbmail.data.model.Contact;
import com.semicolonafrica.mbmail.data.model.User;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    RegistrationResponse register(RegistrationRequest request);
    LoginResponse login(LoginRequest request);
    AddContactResponse addContact(AddContactRequest contactRequest);
    List<Contact> viewContact(User user);

    MessageResponse send(MessageRequest request) throws MessagingException;
}
