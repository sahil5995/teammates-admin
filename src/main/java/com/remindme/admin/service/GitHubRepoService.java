package com.remindme.admin.service;

import com.remindme.admin.rest.response.GitHubRepoResponse;

import java.util.List;

public interface GitHubRepoService {

    List<GitHubRepoResponse> getGitRepoDetails(Long userId);
}
