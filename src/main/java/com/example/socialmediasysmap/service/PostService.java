package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.model.Post;
import com.example.socialmediasysmap.model.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    Post createPost(PostDTO postDTO);
    Post getPostById(Long Id);

    void likePost(Long postId);

    void sharePost(Long postId);

    List<PostDTO> getAllPostsForUser(Long userId);

    void deletePost(Long postId);

    void deleteLike(Long postId);
}
