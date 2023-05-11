package com.example.parrotsysmap.service.user;

import com.example.parrotsysmap.exception.EmailAlreadyExistsException;
import com.example.parrotsysmap.exception.UserNotFoundException;
import com.example.parrotsysmap.dtos.UserDTO;
import org.bson.types.ObjectId;

import java.util.List;


public interface IUserService {
    String createUser(UserDTO user) throws EmailAlreadyExistsException;

    String followUser(ObjectId userId, ObjectId userIdFollowed);

    public String unfollowUser(ObjectId userIdFollower, ObjectId userIdUnFollowed);
    public String getFollowersFromUser(ObjectId userId) throws UserNotFoundException;
    public String getFollowingUsers(ObjectId userId) throws UserNotFoundException;
    String findById(ObjectId userId) throws UserNotFoundException;

    String updateUserName (UserDTO userId) throws UserNotFoundException;

    String findAllUsers();

    List<UserDTO> uploadProfilePhoto();

}
