package com.managementlogisticsystem.managementlogisticsystem.user.controller;


import com.managementlogisticsystem.managementlogisticsystem.user.model.User;
import com.managementlogisticsystem.managementlogisticsystem.user.permission.Permission;
import com.managementlogisticsystem.managementlogisticsystem.user.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        var users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUserPermission/{id}")
    public ResponseEntity<List<Permission>> getUserByID(@PathVariable("id") Long id){
       var userPermission= userService.getPermission(id);
        return new ResponseEntity<>(userPermission, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        var newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        var updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserByID(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
