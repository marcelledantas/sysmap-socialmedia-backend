package com.example.parrotsysmap.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Comment {
    private UUID id;
    private UUID userId;
    private String userFullName;
    private String content;
    private Date createdAt;
    private int likes;

    public Comment(UUID userId, String userFullName, String content, Date createdAt, int likes) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.content = content;
        this.createdAt = createdAt;
        this.likes = likes;
        this.setId();
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }
}
