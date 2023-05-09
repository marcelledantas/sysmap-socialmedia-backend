package com.example.parrotsysmap.service;

import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.model.User;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.dtos.UserDTO;

import java.util.List;


public interface IUserService {
    User createUser(User user);

    void followUser(Long userId);

    void unfollowUser(Long userId);

    List<Post> getAllPostsForUser(Long userId);

    List<User> getFollowersFromUser(Long userId);

    UserDTO findById(Long userId);

    ResponseDTO saveUser(Long userId);

    ResponseDTO updateUser (Long userId);

    List<UserDTO> findAllUsers();

    List<UserDTO> uploadProfilePhoto();
}
