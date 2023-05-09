package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.model.Post;
import com.example.socialmediasysmap.model.User;
import com.example.socialmediasysmap.dtos.ResponseDTO;
import com.example.socialmediasysmap.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public void followUser(Long userId) {

    }

    @Override
    public void unfollowUser(Long userId) {

    }

    @Override
    public List<Post> getAllPostsForUser(Long userId) {
        return null;
    }

    @Override
    public List<User> getFollowersFromUser(Long userId) {
        return null;
    }

    @Override
    public UserDTO findById(Long userId) {
        return null;
    }

    @Override
    public ResponseDTO saveUser(Long userId) {
        return null;
    }

    @Override
    public ResponseDTO updateUser(Long userId) {
        return null;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return null;
    }

    @Override
    public List<UserDTO> uploadProfilePhoto() {
        return null;
    }
}
