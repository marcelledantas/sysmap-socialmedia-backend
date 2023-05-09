package com.example.socialmediasysmap.dtos;

import java.util.Date;

public class CommentDTO {
    private String userFullName;
    private String content;
    private Date createdAt;

    public CommentDTO(String userFullName, String content, Date createdAt) {
        this.userFullName = userFullName;
        this.content = content;
        this.createdAt = createdAt;
    }

}
