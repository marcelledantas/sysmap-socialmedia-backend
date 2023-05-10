package com.example.parrotsysmap.service.user;

import com.example.parrotsysmap.exception.EmailAlreadyExistsException;
import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.model.User;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.dtos.UserDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;


public interface IUserService {
    String createUser(UserDTO user) throws EmailAlreadyExistsException;

    String followUser(ObjectId userId, ObjectId userIdFollowed);

    void unfollowUser(UUID userId);

    List<Post> getAllPostsForUser(UUID userId);

    List<User> getFollowersFromUser(UUID userId);

    UserDTO findById(UUID userId);

    ResponseDTO saveUser(UUID userId);

    ResponseDTO updateUser (UUID userId);

    List<UserDTO> findAllUsers();

    List<UserDTO> uploadProfilePhoto();

}
