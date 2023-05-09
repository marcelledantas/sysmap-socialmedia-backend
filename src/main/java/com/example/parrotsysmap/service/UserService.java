package com.example.parrotsysmap.service;

import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.model.User;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public void followUser(UUID userId) {

    }

    @Override
    public void unfollowUser(UUID userId) {

    }

    @Override
    public List<Post> getAllPostsForUser(UUID userId) {
        return null;
    }

    @Override
    public List<User> getFollowersFromUser(UUID userId) {
        return null;
    }

    @Override
    public UserDTO findById(UUID userId) {
        return null;
    }

    @Override
    public ResponseDTO saveUser(UUID userId) {
        return null;
    }

    @Override
    public ResponseDTO updateUser(UUID userId) {
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
