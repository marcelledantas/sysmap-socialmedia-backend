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

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
