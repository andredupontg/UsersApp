package com.andredupont.usersApp.controllers;

import com.andredupont.usersApp.entities.User;
import com.andredupont.usersApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }
    */

    @GetMapping
    public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, name = "page", defaultValue = "0") int page,@RequestParam(required = false, name = "size", defaultValue = "10") int size){
        return new ResponseEntity<Page<User>>(userService.getUsers(page, size), HttpStatus.OK);
    }

    @GetMapping(value = "/usernames")
    public ResponseEntity<Page<String>> getUsernames(@RequestParam(required = false, name = "page", defaultValue = "0") int page,@RequestParam(required = false, name = "size", defaultValue = "10") int size){
        return new ResponseEntity<Page<String>>(userService.getUsernames(page, size), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "userId") Long userId){
        return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(name = "username") String username){
        return new ResponseEntity<User>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> authenticate(User user){
        return new ResponseEntity<User>(userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword()), HttpStatus.OK);
    }
}
