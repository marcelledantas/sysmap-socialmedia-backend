package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.model.Post;
import com.example.socialmediasysmap.dtos.PostDTO;
import com.example.socialmediasysmap.dtos.ResponseDTO;
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
