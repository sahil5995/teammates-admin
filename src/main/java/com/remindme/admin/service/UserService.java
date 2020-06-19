package com.remindme.admin.service;

import com.remindme.admin.rest.request.UserRequest;
import com.remindme.admin.rest.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUserWithUserId(Long userId);

    UserResponse updateUser(Long id, UserRequest userRequest);

    void deleteUser(Long id);
}
