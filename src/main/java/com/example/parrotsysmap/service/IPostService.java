package com.example.parrotsysmap.service;

import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.dtos.PostDTO;
import com.example.parrotsysmap.dtos.ResponseDTO;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    Post createPost(PostDTO postDTO);
    Post getPostById(UUID Id);

    ResponseDTO likePost(UUID postId);

    ResponseDTO sharePost(UUID postId);

    List<PostDTO> getAllPostsForUser(Long userId);

    ResponseDTO deletePost(UUID postId);

    ResponseDTO deleteLike(UUID postId);

    ResponseDTO removeCommentFromPost(UUID commentId, UUID postId);
}
