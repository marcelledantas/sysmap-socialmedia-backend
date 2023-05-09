package com.example.parrotsysmap.service.user;

import com.example.parrotsysmap.exception.EmailAlreadyExistsException;
import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.model.User;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.dtos.UserDTO;
import com.example.parrotsysmap.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

//    private final PasswordEncoder _passwordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) throws EmailAlreadyExistsException {

        User result = this.userRepository.findUserByEmail(userDTO.getEmail());
        if(result != null) {
            throw new EmailAlreadyExistsException();
        }
        String password = UUID.randomUUID().toString(); //TODO: Mudar como est sendo feita a senha
        User user = getUserFromDto(userDTO, password);
        this.userRepository.save(user);
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

    private User getUserFromDto(UserDTO userDTO, String password){
       return new User(userDTO.getFirstName(), userDTO.getSecondName(), userDTO.getEmail(), password, userDTO.getPhotoUrl(), LocalDateTime.now());
    }
}
