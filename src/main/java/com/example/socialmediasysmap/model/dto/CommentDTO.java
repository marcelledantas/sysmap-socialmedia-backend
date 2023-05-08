package com.example.socialmediasysmap.model.dto;

import java.util.Date;

public class CommentDTO {
    private String userFullName;
    private String content;
    private Date createdAt;

    public CommentDTO getCommentDTO(){
        return new CommentDTO();
    }
}
