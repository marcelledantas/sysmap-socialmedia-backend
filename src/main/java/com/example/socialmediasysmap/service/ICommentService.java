package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.dtos.CommentDTO;
import com.example.socialmediasysmap.dtos.ResponseDTO;

public interface ICommentService {
    ResponseDTO createComment(CommentDTO inputComment, Long postId);

    ResponseDTO getComment(Long inputPostId);

    ResponseDTO findCommentByUserId(Long inputPostId, Long commentId);
}
