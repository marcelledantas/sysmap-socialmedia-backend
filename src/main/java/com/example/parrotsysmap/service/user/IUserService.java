package com.example.parrotsysmap.service.user;

import com.example.parrotsysmap.exception.EmailAlreadyExistsException;
import com.example.parrotsysmap.exception.UserNotFoundException;
import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.model.User;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.dtos.UserDTO;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;


public interface IUserService {
    String createUser(UserDTO user) throws EmailAlreadyExistsException;

    String followUser(ObjectId userId, ObjectId userIdFollowed);

    public String unfollowUser(ObjectId userIdFollower, ObjectId userIdUnFollowed);
    public String getFollowersFromUser(ObjectId userId) throws UserNotFoundException;

    String findById(ObjectId userId) throws UserNotFoundException;

    String updateUserName (UserDTO userId) throws UserNotFoundException;

    List<UserDTO> findAllUsers();

    List<UserDTO> uploadProfilePhoto();

}
