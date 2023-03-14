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
import com.semicolonafrica.mbmail.data.repository.UserRepo;
import com.semicolonafrica.mbmail.utils.UserLoginException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepo userRepo;
    @Autowired
    private MessageService messageService;
    @Autowired
    private ContactService contactService;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        boolean emailExist = userRepo.findByEmailAddress(request.getEmailAddress()).isPresent();
        if (emailExist) throw new IllegalStateException("Email Already Exist");
        User user = new User();
                user.setFirstName(request.getFirstName());
                user.setLastName(request.getLastName());
                user.setEmailAddress(request.getEmailAddress());
                user.setPassword(request.getPassword());
                user.setPhoneNumber(request.getPhoneNumber());
                user.setGender(request.getGender());
        userRepo.save(user);

        return RegistrationResponse.builder()
                .message("Account created successfully")
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepo.findByEmailAddress(request.getEmailAddress())
                .orElseThrow(()-> new UserLoginException("User does not exist"));
        LoginResponse response = new LoginResponse();
        if (user.getPassword().equals(request.getPassword())){
            response.setMessage("Login successful");
            response.setHttpStatus(HttpStatus.OK);
        }else {
            response.setMessage("re-login");
            response.setHttpStatus(HttpStatus.BAD_REQUEST);
            throw new UserLoginException("wrong email or password");
        }
        return response;
    }
    @Override
    public AddContactResponse addContact(AddContactRequest contactRequest) {
        User user = userRepo.findById(contactRequest.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found"));

        if (contactService.contactExist(contactRequest.getContact().getEmailAddress()))
            throw new RuntimeException("Contact exists");

        Contact contact = new Contact();
            contact.setFullName(contactRequest.getContact().getFullName());
            contact.setEmailAddress(contactRequest.getContact().getEmailAddress());
            contactService.addContact(contact);
            user.getContacts().add(contact);
            userRepo.save(user);

        return AddContactResponse.builder()
                .message("contact added successfully")
                .httpStatus(HttpStatus.OK)
                .build();
    }
    @Override
    public List<Contact> viewContact(User user) {
        return user.getContacts();
    }

    @Override
    public MessageResponse send(MessageRequest request) throws MessagingException {
        messageService.send(request);
        return MessageResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Message sent successfully")
                .build();
    }


}
