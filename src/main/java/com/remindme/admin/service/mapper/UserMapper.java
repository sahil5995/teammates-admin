package com.remindme.admin.service.mapper;

import com.remindme.admin.repository.entity.User;
import com.remindme.admin.rest.request.UserRequest;
import com.remindme.admin.rest.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapRequestToEntity(UserRequest userRequest) {

        return User.builder().firstName(userRequest.getFirstName()).
                surName(userRequest.getSurName()).position(userRequest.getPosition()).
                gitHubProfileUrl(userRequest.getGitHubProfileUrl()).build();
    }


    public UserResponse mapEntityToResponse(User entity) {
        return UserResponse.builder().id(entity.getId()).firstName(entity.getFirstName()).
                surName(entity.getSurName()).position(entity.getPosition()).
                githubProfileUrl(entity.getGitHubProfileUrl()).build();
    }


}
