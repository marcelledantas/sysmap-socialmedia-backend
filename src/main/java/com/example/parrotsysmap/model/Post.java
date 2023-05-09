package com.example.parrotsysmap.model;
import  java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
