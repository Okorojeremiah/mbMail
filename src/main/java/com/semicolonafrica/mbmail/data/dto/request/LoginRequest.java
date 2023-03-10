package com.semicolonafrica.mbmail.data.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String emailAddress;
    private String password;
}
