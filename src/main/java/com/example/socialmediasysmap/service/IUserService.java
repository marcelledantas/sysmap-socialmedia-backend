package com.example.socialmediasysmap.service;

import com.example.socialmediasysmap.model.Post;
import com.example.socialmediasysmap.model.User;
import com.example.socialmediasysmap.dtos.ResponseDTO;
import com.example.socialmediasysmap.dtos.UserDTO;

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
