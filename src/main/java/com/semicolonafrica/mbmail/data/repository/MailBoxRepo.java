package com.semicolonafrica.mbmail.data.repository;

import com.semicolonafrica.mbmail.data.model.MailBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailBoxRepo extends JpaRepository<MailBox, Long> {
}
