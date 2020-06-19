package com.remindme.admin.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequest {

    @NotBlank(message = "First name can not be null.")
    private String firstName;

    @NotBlank(message = "Sur name can not be null.")
    private String surName;

    @NotBlank(message = "Position can not be null.")
    private String position;

    @NotBlank(message = "GitHub profile can not be null.")
    @Pattern(regexp = "https://github.com(/[a-zA-Z0-9_]*)/?", message = "Git hub profile URL is incorrect.")
    private String gitHubProfileUrl;

}
