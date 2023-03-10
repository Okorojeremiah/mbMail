package com.semicolonafrica.mbmail.data.dto.request;

import lombok.Data;

import java.io.File;

@Data
public class MessageRequest {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private File attachment;
}
