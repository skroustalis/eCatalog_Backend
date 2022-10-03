package com.juicyCore.eCatalog.services;

import com.juicyCore.eCatalog.dto.UserDTO;
import com.juicyCore.eCatalog.models.UserModel;
import com.juicyCore.eCatalog.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * returns a specified user by id
     * @param userId the user id
     * @return user
     */
    public UserModel getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * returns all users
     * @return a list of all users
     */
    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * adds a new user
     * @param user the new user
     * @return a confirmation string
     */
    public String addUser(UserModel user){
        String response="";
            userRepository.save(user);
            response = "User saved successfully";
        return response;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void deleteAllUsers(){
         userRepository.deleteAll();
    }

    public void UpdateUser(UserDTO userDTO, Long userId){
        UserModel userModel = userRepository.findById(userId).orElse(null);
        userModel.setName(userDTO.getName());
        userModel.setLastname(userDTO.getLastname());
        userModel.setPassword(userDTO.getPassword());
        userModel.setUsername(userDTO.getUsername());
        userRepository.save(userModel);

    }


}
