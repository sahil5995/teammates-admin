package com.remindme.admin.service;

import com.remindme.admin.exception.custom.UserNotFoundException;
import com.remindme.admin.repository.UserRepository;
import com.remindme.admin.repository.entity.User;
import com.remindme.admin.rest.request.UserRequest;
import com.remindme.admin.rest.response.UserResponse;
import com.remindme.admin.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        var userEntity = userMapper.mapRequestToEntity(userRequest);
        User entity = userRepository.save(userEntity);
        return userMapper.mapEntityToResponse(entity);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> list = (List<User>) userRepository.findAll();
        return list.stream().map(userMapper::mapEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserWithUserId(Long id) {
        User user = findUserWithId(id);
        return userMapper.mapEntityToResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest newUser) {
        User user = findUserWithId(id);
        user.setFirstName(newUser.getFirstName());
        user.setSurName(newUser.getSurName());
        user.setPosition(newUser.getPosition());
        user.setGitHubProfileUrl(newUser.getGitHubProfileUrl());

        var updatedUser = userRepository.save(user);
        return userMapper.mapEntityToResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findUserWithId(id);
        userRepository.delete(user);
    }


    private User findUserWithId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id %s not found", id));
    }

}
