package com.semicolonafrica.mbmail.service;

import com.semicolonafrica.mbmail.data.dto.request.MessageRequest;
import com.semicolonafrica.mbmail.data.model.MailBox;
import com.semicolonafrica.mbmail.data.model.Message;
import com.semicolonafrica.mbmail.data.repository.MessageRepo;

import jakarta.mail.MessagingException;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private MailBoxService mailBoxService;

    @Autowired
    private JavaMailSender javaMailSender;



    @Override
    public void send(MessageRequest request) {

        Message message = new Message();
        message.setSender(request.getSender());
        message.setRecipient(request.getRecipient());
        message.setSubject(request.getSubject());
        message.setBody(request.getBody());
        message.setDateTime(LocalDateTime.now());

        messageRepo.save(message);
        MailBox mailBox = new MailBox();
        mailBox.getSent().add(message);
        mailBoxService.save(mailBox);

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setTo(request.getRecipient());
            mimeMessageHelper.setFrom(request.getSender());
            mimeMessageHelper.setText(request.getBody());
            mimeMessageHelper.setSubject(request.getSubject());
            mimeMessageHelper.addAttachment("file", request.getAttachment());
            javaMailSender.send(mimeMessage);

        }catch (MessagingException e){
            log.info("problem 1: " + e.getMessage());
        }catch (MailException e){
            log.info("problem 2: "+ e.getMessage());
        }

    }
}
