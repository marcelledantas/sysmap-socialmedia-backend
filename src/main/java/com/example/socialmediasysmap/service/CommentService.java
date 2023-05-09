package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.dtos.CommentDTO;
import com.example.socialmediasysmap.dtos.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Override
    public ResponseDTO createComment(CommentDTO inputComment, Long postId) {
        return null;
    }

    @Override
    public ResponseDTO getComment(Long inputPostId) {
        return null;
    }

    @Override
    public ResponseDTO findCommentByUserId(Long inputPostId, Long commentId) {
        return null;
    }
}
