package com.remindme.admin.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponse {

    private Long id;

    private String firstName;

    private String surName;

    private String position;

    private String githubProfileUrl;

}
