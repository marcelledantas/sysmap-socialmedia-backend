package com.example.socialmediasysmap.controller;

import com.example.socialmediasysmap.dtos.CommentDTO;
import com.example.socialmediasysmap.dtos.ResponseDTO;
import com.example.socialmediasysmap.service.ICommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private ICommentService commentService;

    public ICommentService getCommentService() {
        return commentService;
    }

    @PostMapping("/insert/{postId}")
    ResponseEntity<ResponseDTO> createComment(@PathVariable CommentDTO postedComment, Long postId){
        ResponseDTO result = this.commentService.createComment(postedComment, postId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/post/{postId}/comments/{commentId}/")
    ResponseEntity<ResponseDTO> getCommentFromPost(@PathVariable Long postId, @PathVariable Long commentId){
        ResponseDTO result = this.commentService.findCommentByUserId(postId, commentId);
        return ResponseEntity.ok(result);
    }

}
