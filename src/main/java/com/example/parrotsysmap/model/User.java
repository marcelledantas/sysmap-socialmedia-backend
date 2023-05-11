package com.example.parrotsysmap.model;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class User {
    @Id
    private ObjectId id;
    private String fullName;
    private String email;
    private String password;
    private String photoUrl;
    private LocalDateTime created;

    private List<User> followers = new ArrayList<>();
    private List<User> following = new ArrayList<>();

    public User(String fullName, String email, String password, String photoUrl, LocalDateTime created) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.photoUrl = photoUrl;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Usuário{" +
                "Nome='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photoUrl + '\'' +
                '}';
    }
}

