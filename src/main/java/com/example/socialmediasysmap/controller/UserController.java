package com.example.socialmediasysmap.controller;

import com.example.socialmediasysmap.model.Post;
import com.example.socialmediasysmap.model.User;
import com.example.socialmediasysmap.dtos.ResponseDTO;
import com.example.socialmediasysmap.dtos.UserDTO;
import com.example.socialmediasysmap.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @PostMapping("/{userId}/follow")
    public ResponseEntity<Void> followUser(@PathVariable Long userId) {
        userService.followUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/unfollow")
    public ResponseEntity<Void> unfollowUser(@PathVariable Long userId) {
        userService.unfollowUser(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<Post>> getAllPostsFromUser(@PathVariable Long userId) {
        List<Post> posts = userService.getAllPostsForUser(userId);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{userId}/followers")
    public ResponseEntity<List<User>> getPostFromFollowers(@PathVariable Long userId) {
        List<User> users = this.userService.getFollowersFromUser(userId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> findById(@RequestBody Long userId) {
        UserDTO user = this.userService.findById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveUser(@RequestBody Long userId) {
        ResponseDTO result = this.userService.saveUser(userId);
        return ResponseEntity.ok(result);
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> update(@RequestBody Long userId) {
        ResponseDTO result = this.userService.updateUser(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/profile/all")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<UserDTO> user = this.userService.findAllUsers();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/photo")
    public ResponseEntity<List<UserDTO>> uploadProfilePhoto(MultipartFile photo) {
        List<UserDTO> user = this.userService.uploadProfilePhoto();
        return ResponseEntity.ok(user);
    }

//    @PostMapping("/delete/{postId}")
//    public ResponseEntity deleteUser(@PathVariable Long postId) {
//        this.use
//    }

//    @PostMapping("/users/signin")
//    public ResponseEntity<ResponseDTO> userSignIn(@RequestBody Login inputUser) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(inputUser.getEmail(), inputUser.getPassword()));
//            String token = jwtUtil.generateToken(inputUser.getEmail());
//
//            Optional<UserEntity> optUser = userRepo.findByEmail(inputUser.getEmail());
//            UserEntity user = optUser.get();
//            user.setPassword("");
//            return new ResponseEntity<ResponseObjectService>(new ResponseObjectService("success", "authenticated", new AuthorizedEntity(user, token)), HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<ResponseObjectService>(new ResponseObjectService("fail", "unauthenticated", null), HttpStatus.OK);
//        }
//    }

}
