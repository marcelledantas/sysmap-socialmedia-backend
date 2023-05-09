package com.example.parrotsysmap.service.comment;

import com.example.parrotsysmap.dtos.CommentDTO;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.model.Post;

import java.util.UUID;

public interface ICommentService {
    ResponseDTO createComment(CommentDTO inputComment, UUID postId);

    ResponseDTO getComment(Long inputPostId);

    ResponseDTO findCommentByUserId(UUID inputPostId, UUID commentId);

    Post getAllCommentsByPostId(UUID postId);
}
