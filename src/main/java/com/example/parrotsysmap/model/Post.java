package com.example.parrotsysmap.model;
import lombok.Data;

import  java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Data
public class Post {
    private UUID id;
    private UUID userId;
    private String userFullName;
    private Date createdAt;

    private List<Comment> comments;

    private int likes;

    public Post(UUID userId, String userFullName, Date createdAt, List<Comment> comments, int likes) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.createdAt = createdAt;
        this.comments = comments;
        this.likes = likes;
        this.setId();
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }
}
