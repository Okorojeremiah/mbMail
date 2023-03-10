package com.semicolonafrica.mbmail.data.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class LoginResponse {
    private String message;
    private HttpStatus httpStatus;
}
