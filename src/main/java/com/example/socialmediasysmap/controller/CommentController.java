package com.example.socialmediasysmap.controller;

import com.example.socialmediasysmap.model.dto.CommentDTO;
import com.example.socialmediasysmap.model.dto.ResponseDTO;
import com.example.socialmediasysmap.service.CommentService;
import com.example.socialmediasysmap.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private CommentService commentService;

    public CommentService getCommentService() {
        return commentService;
    }

    @PostMapping("/insert/{postId}")
    ResponseEntity<ResponseDTO> createComment(@RequestBody CommentDTO postedComment, Long postId){
        CommentDTO inputComment = postedComment.getCommentDTO();
        ResponseDTO result = this.commentService.createComment(inputComment);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/post/{postId}/comments/{commentId}/")
    ResponseEntity<ResponseDTO> getCommentFromPost(@PathVariable Long postId, @PathVariable Long commentId){
        ResponseDTO result = this.commentService.findCommentByUserId(postId, commentId);
        return ResponseEntity.ok(result);
    }

}
