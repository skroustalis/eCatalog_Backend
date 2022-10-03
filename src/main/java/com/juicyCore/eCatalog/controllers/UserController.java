package com.juicyCore.eCatalog.controllers;

import com.juicyCore.eCatalog.dto.UserDTO;
import com.juicyCore.eCatalog.models.UserModel;
import com.juicyCore.eCatalog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService usersService;

    @Autowired
    public UserController(UserService usersService) {
        this.usersService = usersService;
    }

    /**
     * returns all users
     * @return a list of all users
     */
    @GetMapping(path = "/allUsers")
    public List<UserModel> getAllUsers(){
        return usersService.getAllUsers();
    }

    /**
     * returns a specified user by id
     * @param userId the user id
     * @return user
     */
    @GetMapping(path = "/User{id}")
    public UserModel getUser(@PathVariable(value = "id") Long userId) {
        return usersService.getUser(userId);
    }

    /**
     * adds a new user
     * @param user a new user
     * @return a confirmation string
     */
    @PostMapping(path ="/addUser")
    public String addNew(@RequestBody UserModel user){
        return usersService.addUser(user);
    }

    @DeleteMapping(path ="/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long userId)
    {usersService.deleteUser(userId);
        return "Successfully deleted user";}

    @DeleteMapping(path ="/deleteAllUsers")
    public void deleteAllUsers()
    {usersService.deleteAllUsers();}

    @PutMapping (path = "/updateUser/{id}")
    public UserDTO updateUser(@PathVariable(value = "id") Long userId, @RequestBody UserDTO user){
         usersService.UpdateUser(user, userId);
         return user;
    }

}
