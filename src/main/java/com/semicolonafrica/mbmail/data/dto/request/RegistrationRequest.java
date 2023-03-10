package com.semicolonafrica.mbmail.data.dto.request;

import com.semicolonafrica.mbmail.data.model.Gender;
import lombok.Data;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private Gender gender;
}
