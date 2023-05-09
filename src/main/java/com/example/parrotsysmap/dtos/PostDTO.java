package com.example.parrotsysmap.dtos;

import com.example.parrotsysmap.model.Comment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostDTO {
    private String userFullName;
    private Date createdAt;

    private List<Comment> comments;

    private int likes;

    public PostDTO(String userFullName, Date createdAt, List<Comment> comments, int likes) {
        this.userFullName = userFullName;
        this.createdAt = createdAt;
        this.comments = comments;
        this.likes = likes;
    }
}
