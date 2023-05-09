package com.example.parrotsysmap.controller;

import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.dtos.PostDTO;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.service.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post")
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO inputPost) {
        Post result = this.postService.createPost(inputPost);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Long postId) {
        Post result = this.postService.getPostById(postId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<ResponseDTO> likePost(@PathVariable Long postId) {
        ResponseDTO result = this.postService.likePost(postId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{postId}/share")
    public ResponseEntity<ResponseDTO> sharePost(@PathVariable Long postId) {
        ResponseDTO result = this.postService.sharePost(postId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{postId}/delete/post")
    public ResponseEntity<ResponseDTO> deletePost(@PathVariable Long postId){
        ResponseDTO result = this.postService.deletePost(postId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{postId}/delete/like")
    public ResponseEntity<ResponseDTO> deleteLikeFromPost(@PathVariable Long postId){
        ResponseDTO result =  this.postService.deleteLike(postId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{postId}/all")
    public ResponseEntity<Post> getAllCommentsFromPost(@PathVariable Long postId) {
        Post result = this.postService.getPostById(postId);
        return ResponseEntity.ok(result);
    }


    //remove comment
    @PostMapping("/comment/{commentId}/{postId}")
    ResponseEntity<ResponseDTO> deleteComment(@PathVariable Long commentId, @PathVariable Long postId){
        ResponseDTO result = this.postService.removeCommentFromPost(commentId, postId);
        return ResponseEntity.ok(result);
    }
}
