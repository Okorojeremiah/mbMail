package com.semicolonafrica.mbmail.controller;

import com.semicolonafrica.mbmail.data.dto.request.AddContactRequest;
import com.semicolonafrica.mbmail.data.dto.request.LoginRequest;
import com.semicolonafrica.mbmail.data.dto.request.MessageRequest;
import com.semicolonafrica.mbmail.data.dto.request.RegistrationRequest;
import com.semicolonafrica.mbmail.service.UserService;
import com.semicolonafrica.mbmail.utils.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("api/v1/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest request, HttpServletRequest httpServletRequest){
        ApiResponse response = ApiResponse.builder()
                .timeStamp(ZonedDateTime.now())
                .statusCode(HttpStatus.CREATED)
                .path(httpServletRequest.getRequestURI())
                .data(userService.register(request))
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request, HttpServletRequest httpServletRequest){
        ApiResponse response = ApiResponse.builder()
                .timeStamp(ZonedDateTime.now())
                .statusCode(HttpStatus.OK)
                .path(httpServletRequest.getRequestURI())
                .data(userService.login(request))
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("add-contact")
    public ResponseEntity<ApiResponse> addContact(@RequestBody AddContactRequest request, HttpServletRequest httpServletRequest){
        ApiResponse response = ApiResponse.builder()
                .timeStamp(ZonedDateTime.now())
                .statusCode(HttpStatus.OK)
                .path(httpServletRequest.getRequestURI())
                .data(userService.addContact(request))
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("send-message")
    public ResponseEntity<ApiResponse> send(@RequestBody MessageRequest request, HttpServletRequest httpServletRequest) throws MessagingException {
        ApiResponse response = ApiResponse.builder()
                .timeStamp(ZonedDateTime.now())
                .statusCode(HttpStatus.OK)
                .path(httpServletRequest.getRequestURI())
                .data(userService.send(request))
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
