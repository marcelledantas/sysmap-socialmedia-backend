package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.model.dto.CommentDTO;
import com.example.socialmediasysmap.model.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    ResponseDTO createComment(CommentDTO inputComment);

    ResponseDTO getComment(Long inputPostId);

    ResponseDTO findCommentByUserId(Long inputPostId, Long commentId);
}
