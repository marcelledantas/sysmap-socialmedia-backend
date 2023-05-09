package com.example.parrotsysmap.service;

import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.dtos.PostDTO;
import com.example.parrotsysmap.dtos.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService implements IPostService {

    @Override
    public Post createPost(PostDTO postDTO) {
        return null;
    }

    @Override
    public Post getPostById(UUID Id) {
        return null;
    }

    @Override
    public ResponseDTO likePost(UUID postId) {

        return null;
    }

    @Override
    public ResponseDTO sharePost(UUID postId) {

        return null;
    }

    @Override
    public List<PostDTO> getAllPostsForUser(Long userId) {
        return null;
    }

    @Override
    public ResponseDTO deletePost(UUID postId) {

        return null;
    }

    @Override
    public ResponseDTO deleteLike(UUID postId) {

        return null;
    }

    @Override
    public ResponseDTO removeCommentFromPost(UUID commentId, UUID postId) {
        return null;
    }
}
