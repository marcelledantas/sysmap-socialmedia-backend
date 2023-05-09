package com.example.parrotsysmap.service;

import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.dtos.PostDTO;
import com.example.parrotsysmap.dtos.ResponseDTO;

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
