package com.example.parrotsysmap.service;

import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.dtos.PostDTO;
import com.example.parrotsysmap.dtos.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Override
    public Post createPost(PostDTO postDTO) {
        return null;
    }

    @Override
    public Post getPostById(Long Id) {
        return null;
    }

    @Override
    public ResponseDTO likePost(Long postId) {

        return null;
    }

    @Override
    public ResponseDTO sharePost(Long postId) {

        return null;
    }

    @Override
    public List<PostDTO> getAllPostsForUser(Long userId) {
        return null;
    }

    @Override
    public ResponseDTO deletePost(Long postId) {

        return null;
    }

    @Override
    public ResponseDTO deleteLike(Long postId) {

        return null;
    }

    @Override
    public ResponseDTO removeCommentFromPost(Long commentId, Long postId) {
        return null;
    }
}
