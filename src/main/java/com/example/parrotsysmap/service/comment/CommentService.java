package com.example.parrotsysmap.service.comment;

import com.example.parrotsysmap.dtos.CommentDTO;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.model.Post;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentService implements ICommentService {

    @Override
    public ResponseDTO createComment(CommentDTO inputComment, UUID postId) {
        return null;
    }

    @Override
    public ResponseDTO getComment(Long inputPostId) {
        return null;
    }

    @Override
    public ResponseDTO findCommentByUserId(UUID inputPostId, UUID commentId) {
        return null;
    }

    @Override
    public Post getAllCommentsByPostId(UUID postId) {
        return null;
    }
}
