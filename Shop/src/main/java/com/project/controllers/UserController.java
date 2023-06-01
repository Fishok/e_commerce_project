package com.project.controllers;

import com.project.codeReturn.Codes;
import com.project.domain.entity.User;
import com.project.dto.UserDTO;
import com.project.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.project.api.ApiConstants.*;

@RestController
public class UserController{

    private static final String[] GET_existsByUsername = null;
	@Autowired
    UserInterface service;

    @GetMapping(value = GET_UserByUserName)
    public User getUserByUsername(@RequestParam String username) {
        return service.getUserByUsername(username);
    }

    @PostMapping(value = ADD_User)
    public Codes addUser(@RequestBody UserDTO user) {
        return service.addUser(user);
    }

    @PostMapping(value = SET_User)
    public Codes updateUser(@RequestBody UserDTO user) {
        return service.updateUser(user);
    }

    @DeleteMapping(value = DELETE_User)
    public Codes removeUser(@RequestParam String username,@RequestParam String password) {
        return service.removeUser(username,password);
    }

    @PostMapping(value = SET_Password)// TODO ??
    public Codes updatePassword(@RequestBody String username, String oldPassword, String newPassword, String newPasswordCheck) {
        return service.updatePassword(username, oldPassword, newPassword, newPasswordCheck);
    }

//    @GetMapping(value = GET_existsByUsername)
//    public Codes existsByUsername(@RequestParam String username) {
//        return service.existsByUsername(username);
//   }

    @GetMapping(value = GET_ExistsByEmail)
    public boolean existsByEmail(@RequestParam String email) {
        return service.existsByEmail(email);
    }
}
