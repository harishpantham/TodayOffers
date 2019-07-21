package com.today.offers.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.today.offers.dto.UserDTO;
import com.today.offers.serviceI.UserServiceI;
import com.today.offers.utils.OffersResponse;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    @GetMapping("/users")
    public OffersResponse  getAllUsers() {
        return userServiceI.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public OffersResponse  getUserById(@PathVariable Long userId) {
        return userServiceI.getUserById(userId);
    }

    @PostMapping("/users")
    public OffersResponse saveUser(@RequestBody UserDTO userDTO) {
        return userServiceI.saveUser(userDTO);
    }

    @PutMapping("/users/{userId}")
    public OffersResponse updateUser(@RequestBody UserDTO userDTO) {
        return userServiceI.updateUser(userDTO);
    }

    @DeleteMapping("/users/{userId}")
    public OffersResponse deleteUser(@PathVariable Long userId) {
        return userServiceI.deleteUser(userId);
    }
}
