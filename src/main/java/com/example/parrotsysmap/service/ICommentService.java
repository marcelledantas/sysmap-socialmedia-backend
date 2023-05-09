package com.example.parrotsysmap.service;

import com.example.parrotsysmap.dtos.CommentDTO;
import com.example.parrotsysmap.dtos.ResponseDTO;

public interface ICommentService {
    ResponseDTO createComment(CommentDTO inputComment, Long postId);

    ResponseDTO getComment(Long inputPostId);

    ResponseDTO findCommentByUserId(Long inputPostId, Long commentId);
}
