package com.remindme.admin.rest.controller;


import com.remindme.admin.rest.request.UserRequest;
import com.remindme.admin.rest.response.UserResponse;
import com.remindme.admin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/getAll")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "get/{userId}")
    public UserResponse getUser(@PathVariable("userId") Long userId) {
        return userService.getUserWithUserId(userId);
    }

    @PutMapping(value = "update/{userId}")
    public UserResponse updateUser(@PathVariable("userId") Long userId, @RequestBody @Valid UserRequest userRequest) {
        return userService.updateUser(userId, userRequest);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }


}
