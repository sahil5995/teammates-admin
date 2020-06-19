package com.remindme.admin.rest.controller;

import com.remindme.admin.rest.response.GitHubRepoResponse;
import com.remindme.admin.service.GitHubRepoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class GitHubRepoController {

    private GitHubRepoService gitHubRepoService;

    public GitHubRepoController(GitHubRepoService gitHubRepoService) {
        this.gitHubRepoService = gitHubRepoService;
    }

    @GetMapping(value = "/users/{userId}/repositories")
    public List<GitHubRepoResponse> getUserGitHubRepos(@PathVariable("userId") Long userId) {
        return gitHubRepoService.getGitRepoDetails(userId);
    }
}
