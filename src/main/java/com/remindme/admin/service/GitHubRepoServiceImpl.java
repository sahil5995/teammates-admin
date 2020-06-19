package com.remindme.admin.service;

import com.remindme.admin.github.GitAdapterResponse;
import com.remindme.admin.github.GitHubAdapter;
import com.remindme.admin.rest.response.GitHubRepoResponse;
import com.remindme.admin.service.mapper.GitRepoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubRepoServiceImpl implements GitHubRepoService {

    private GitHubAdapter gitHubAdapter;
    private UserService userService;
    private GitRepoMapper gitRepoMapper;

    public GitHubRepoServiceImpl(GitHubAdapter gitHubAdapter, UserService userService, GitRepoMapper gitRepoMapper) {
        this.gitHubAdapter = gitHubAdapter;
        this.userService = userService;
        this.gitRepoMapper = gitRepoMapper;
    }

    @Override
    public List<GitHubRepoResponse> getGitRepoDetails(Long userId) {
        var user = userService.getUserWithUserId(userId);
        List<GitAdapterResponse> adapterResponses = gitHubAdapter.getRepositories(user.getGithubProfileUrl());
        return adapterResponses.stream().map(gitRepoMapper::mapAdapterToResponse).collect(Collectors.toList());
    }
}
