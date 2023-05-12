package com.example.parrotsysmap.service.user;

import com.example.parrotsysmap.exception.EmailAlreadyExistsException;
import com.example.parrotsysmap.exception.UserNotFoundException;
import com.example.parrotsysmap.model.User;
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

            List<User> followerList = userFollower.getFollowing();

            if(followerList == null){
                followerList = new ArrayList<>();
            }
            else{
                //Check if userIdFollower already follows userIdFollowed
                for(User user : followerList){
                    if(user.getId().equals(userIdFollowed)){
                        responseMap.put("status", "falhou");
                        String msgResponse = String.format("%s já segue %s", userFollower.getFullName(), userFollowed.getFullName());
                        responseMap.put("mensagem", msgResponse);
                        return responseMap.toString();
                    }
                }
            }

            followerList.add(userFollowed);
            userFollower.setFollowing(followerList);

            this.userRepository.save(userFollower);

            List<User> followingList = userFollowed.getFollowers();
            if(followingList == null){
                followingList = new ArrayList<>();
            }


            User newUserFollower = this.userRepository.findById(userIdFollower).get();

            followingList.add(newUserFollower);
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

        User userFollowed = optUserUnfollowed.get();
        User userFollower = optUserFollower.get();
        List<User> userFollowingList = userFollower.getFollowing();
        if(userFollowingList == null){
            userFollowingList = new ArrayList<>();
        }

        boolean isFollowed = false;

        for(User u : userFollowingList){
            if (u.getId().equals(userIdUnfollowed)) {
                isFollowed = true;
                break;
            }
        }

        if(isFollowed){
            userFollowingList.remove(userFollowed);
            userFollower.setFollowing(userFollowingList);
            this.userRepository.save(userFollower);
            responseMap.put("status", "sucesso");
            responseMap.put("Usuário", userFollower.getFullName());
            responseMap.put("Lista de usuários que está seguindo", userFollower.getFollowing().toString());

            return responseMap.toString();
        }
        else{
            responseMap.put("mensagem", String.format("Falha a dar unfollow, usuário %s não segue %s", userFollowed.getFullName(), userFollowed.getFullName()));
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
    public String updateUserName(UserDTO userRequest) throws UserNotFoundException {
        HashMap<String, UserDTO> responseMap = new HashMap<>();

        User userFind = this.userRepository.findUserByEmail(userRequest.getEmail());
        if(userFind == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        else{
            userFind.setFullName(userRequest.getFullName());
            this.userRepository.save(userFind);
            UserDTO userDTO = new UserDTO(userFind.getFullName(), userFind.getPhotoUrl(), userFind.getEmail());
            responseMap.put("usuário", userDTO);
            return responseMap.toString();
        }
    }

    @Override
    public String getFollowersFromUser(ObjectId userId) throws UserNotFoundException {

        Optional<User> userFind = this.userRepository.findById(userId);
        if(userFind.isEmpty()){
            throw new UserNotFoundException("Usuário não encontrado");
        }
        else{
            HashMap<String, String> responseMap = new HashMap<>();
            User user = userFind.get();
            List<User> userFollowers = user.getFollowers();
            responseMap.put("status", "sucesso");
            responseMap.put("Seguindo", userFollowers.toString());
            return responseMap.toString();
        }
    }

    @Override
    public String getFollowingUsers(ObjectId userId) throws UserNotFoundException {
        Optional<User> userFind = this.userRepository.findById(userId);
        if(userFind.isEmpty()){
            throw new UserNotFoundException("Usuário não encontrado");
        }
        else{
            HashMap<String, String> responseMap = new HashMap<>();
            User user = userFind.get();
            List<User> userFollowing = user.getFollowing();
            responseMap.put("status", "sucesso");
            responseMap.put("Seguindo", userFollowing.toString());
            return responseMap.toString();
        }
    }

    @Override
    public String findAllUsers() {
        List<User> users = this.userRepository.findAll();
        HashMap<String, String> responseMap = new HashMap<>();
        if(users.isEmpty()){
            return responseMap.put("mensagem", "Não há nenhum usuário ativo na rede Parrot").toString();
        }
        return responseMap.put("mensagem", users.toString());
    }

    @Override
    public List<UserDTO> uploadProfilePhoto() {
        return null;
    }

//    @Override
//    public List<Post> getAllPostsForUser(UUID userId) {
//        return null;
//    }

    private User getUserFromDto(UserDTO userDTO, String password){
       return new User(userDTO.getFullName(), userDTO.getEmail(), password, userDTO.getPhotoUrl(), LocalDateTime.now());
    }
}
