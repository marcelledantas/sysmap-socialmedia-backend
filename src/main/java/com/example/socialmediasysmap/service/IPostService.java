package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.model.Post;
import com.example.socialmediasysmap.dtos.PostDTO;
import com.example.socialmediasysmap.dtos.ResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPostService {
    Post createPost(PostDTO postDTO);
    Post getPostById(Long Id);

    ResponseDTO likePost(Long postId);

    ResponseDTO sharePost(Long postId);

    List<PostDTO> getAllPostsForUser(Long userId);

    ResponseDTO deletePost(Long postId);

    ResponseDTO deleteLike(Long postId);

    ResponseDTO removeCommentFromPost(Long commentId, Long postId);
}
