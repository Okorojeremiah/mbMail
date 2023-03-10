package com.semicolonafrica.mbmail.service;

import com.semicolonafrica.mbmail.data.dto.request.MessageRequest;
import jakarta.mail.MessagingException;
import org.springframework.scheduling.annotation.Async;

public interface MessageService {

    @Async
    void send(MessageRequest messageRequest) throws MessagingException;
}
