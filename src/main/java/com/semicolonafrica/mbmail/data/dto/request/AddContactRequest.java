package com.semicolonafrica.mbmail.data.dto.request;

import com.semicolonafrica.mbmail.data.model.Contact;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddContactRequest {
    private Long userId;
    private Contact contact;
}
