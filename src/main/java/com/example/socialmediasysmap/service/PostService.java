package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.model.Post;
import com.example.socialmediasysmap.model.dto.PostDTO;
import com.example.socialmediasysmap.model.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    Post createPost(PostDTO postDTO);
    Post getPostById(Long Id);

    ResponseDTO likePost(Long postId);

    ResponseDTO sharePost(Long postId);

    List<PostDTO> getAllPostsForUser(Long userId);

    ResponseDTO deletePost(Long postId);

    ResponseDTO deleteLike(Long postId);

    ResponseDTO removeCommentFromPost(Long commentId, Long postId);
}
