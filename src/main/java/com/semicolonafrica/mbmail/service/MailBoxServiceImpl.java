package com.semicolonafrica.mbmail.service;

import com.semicolonafrica.mbmail.data.model.MailBox;
import com.semicolonafrica.mbmail.data.repository.MailBoxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailBoxServiceImpl implements MailBoxService{

    @Autowired
    private MailBoxRepo mailBoxRepo;
    @Override
    public void save(MailBox mailBox) {
        mailBoxRepo.save(mailBox);
    }
}
