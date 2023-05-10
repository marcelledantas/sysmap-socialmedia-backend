package com.example.parrotsysmap.service.user;

import com.example.parrotsysmap.exception.EmailAlreadyExistsException;
import com.example.parrotsysmap.exception.UserNotFoundException;
import com.example.parrotsysmap.model.Post;
import com.example.parrotsysmap.model.User;
import com.example.parrotsysmap.dtos.ResponseDTO;
import com.example.parrotsysmap.dtos.UserDTO;
import com.example.parrotsysmap.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

//    private final PasswordEncoder _passwordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public String createUser(UserDTO userDTO) throws EmailAlreadyExistsException {

        HashMap<String, String> responseMap = new HashMap<>();

        User result = this.userRepository.findUserByEmail(userDTO.getEmail());
        if(result != null) {
            throw new EmailAlreadyExistsException();
        }
        String password = UUID.randomUUID().toString(); //TODO: Mudar como est sendo feita a senha
        User user = getUserFromDto(userDTO, password);
        this.userRepository.save(user);

        responseMap.put("mensagem", "Usuário criado com sucesso");
        responseMap.put("usuário", user.getFullName());

        return responseMap.toString();
    }

    @Transactional
    @Override
    public String followUser(ObjectId userIdFollower, ObjectId userIdFollowed) {

        HashMap<String, String> responseMap = new HashMap<>();

        Optional<User> optUserFollower = this.userRepository.findById(userIdFollower);
        Optional<User> optUserFollowed = this.userRepository.findById(userIdFollowed);

        if(optUserFollower.isEmpty() || optUserFollowed.isEmpty()){
            responseMap.put("mensagem", "usuário não existe");
            return responseMap.toString();
        }
        else{
            User userFollower = optUserFollower.get();
            User userFollowed = optUserFollowed.get();

            List<ObjectId> followerList = userFollower.getFollowing();

            if(followerList == null){
                followerList = new ArrayList<>();
            }
            else{
                //Check if userIdFollower already follows userIdFollowed
                for(ObjectId id : followerList){
                    if(id.equals(userIdFollowed)){
                        responseMap.put("status", "falhou");
                        String msgResponse = String.format("%s já segue %s", userFollower.getFullName(), userFollowed.getFullName());
                        responseMap.put("mensagem", msgResponse);
                        return responseMap.toString();
                    }
                }
            }

            followerList.add(userIdFollowed);
            userFollower.setFollowing(followerList);

            this.userRepository.save(userFollower);

            List<ObjectId> followingList = userFollowed.getFollowers();
            if(followingList == null){
                followingList = new ArrayList<>();
            }
            followingList.add(userIdFollower);
            userFollowed.setFollowers(followingList);

            this.userRepository.save(userFollowed);

            responseMap.put("status", "sucesso");

            String msgResponse = String.format("%s começou a seguir %s", userFollower.getFullName(), userFollowed.getFullName());
            responseMap.put("mensagem", msgResponse);
        }
        return responseMap.toString();
    }

    @Override
    public String unfollowUser(ObjectId userIdFollower, ObjectId userIdUnfollowed) {

        HashMap<String, String> responseMap = new HashMap<>();

        Optional<User> optUserFollower = this.userRepository.findById(userIdFollower);
        Optional<User> optUserUnfollowed = this.userRepository.findById(userIdUnfollowed);

        if(optUserFollower.isEmpty() || optUserUnfollowed.isEmpty()){
            responseMap.put("mensagem", "usuário não existe");
            return responseMap.toString();
        }

        User user = optUserFollower.get();
        List<ObjectId> userFollowingList = user.getFollowing();
        if(userFollowingList == null){
            userFollowingList = new ArrayList<>();
        }

        boolean isFollowed = false;

        for(ObjectId id : userFollowingList){
            if(id.equals(userIdUnfollowed)){
                isFollowed = true;
            }
        }

        if(isFollowed){
            userFollowingList.remove(userIdUnfollowed);
            user.setFollowing(userFollowingList);
            this.userRepository.save(user);
            responseMap.put("status", "sucesso");
            responseMap.put("Usuário", user.getFullName());
            responseMap.put("Lista de usuários que está seguindo", user.getFollowing().toString());

            return responseMap.toString();
        }
        else{
            User userFollowed = optUserUnfollowed.get();
            responseMap.put("mensagem", String.format("Falha a dar unfollow, usuário %s não segue %s", user.getFullName(), userFollowed.getFullName()));
            return responseMap.toString();
        }

    }

    @Override
    public String findById(ObjectId userId) throws UserNotFoundException {
        HashMap<String, UserDTO> responseMap = new HashMap<>();

        Optional<User> userFind = this.userRepository.findById(userId);
        if(userFind.isEmpty()){
            throw new UserNotFoundException("Usuário não encontrado");
        } else{
            User user = userFind.get();
            UserDTO userDTO = new UserDTO(user.getFullName(), user.getPhotoUrl(), user.getEmail());
            responseMap.put("usuário", userDTO);
            return responseMap.toString();
        }
    }

    @Override
    public List<User> getFollowersFromUser(UUID userId) {
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

    @Override
    public List<Post> getAllPostsForUser(UUID userId) {
        return null;
    }

    private User getUserFromDto(UserDTO userDTO, String password){
       return new User(userDTO.getFullName(), userDTO.getEmail(), password, userDTO.getPhotoUrl(), LocalDateTime.now());
    }
}
