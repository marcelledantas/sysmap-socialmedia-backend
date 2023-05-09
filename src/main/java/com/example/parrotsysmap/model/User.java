package com.example.parrotsysmap.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class User {
    @Id
    private UUID id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String photoUrl;
    private LocalDateTime created;

    private List<String> followers = new java.util.ArrayList<>();
    private List<String> following = new java.util.ArrayList<>();

    public User(String firstName, String secondName, String email, String password, String photoUrl, LocalDateTime created) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.photoUrl = photoUrl;
        this.created = created;
        this.setId();
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }
}

