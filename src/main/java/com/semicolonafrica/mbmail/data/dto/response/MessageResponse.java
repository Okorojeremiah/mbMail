package com.semicolonafrica.mbmail.data.dto.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class MessageResponse {
    private String message;
    private HttpStatus httpStatus;
}
