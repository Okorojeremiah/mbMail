package com.semicolonafrica.mbmail.data.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mail_box")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@NoArgsConstructor
public class MailBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @ToString.Exclude
    private List<Message> inbox;
    @OneToMany
    @ToString.Exclude
    private List<Message> sent = new ArrayList<>();
    @OneToMany
    @ToString.Exclude
    private List<Message> trash;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MailBox mailBox = (MailBox) o;
        return id != null && Objects.equals(id, mailBox.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
