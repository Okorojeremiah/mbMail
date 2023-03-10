package com.semicolonafrica.mbmail.data.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class AddContactResponse {
    private String message;
    private HttpStatus httpStatus;
}
