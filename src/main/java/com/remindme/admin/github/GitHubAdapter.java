package com.remindme.admin.github;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class GitHubAdapter {

    private RestTemplate restTemplate;
    private GitHubConfig gitHubConfig;

    public GitHubAdapter(RestTemplate restTemplate, GitHubConfig gitHubConfig) {
        this.restTemplate = restTemplate;
        this.gitHubConfig = gitHubConfig;
    }

    public List<GitAdapterResponse> getRepositories(String getGithubProfileUrl) {
        String username = gitHubConfig.getUsernameFromURL(getGithubProfileUrl);
        var gitAPIResponse = restTemplate.exchange(gitHubConfig.getGitHubAPIURL(username), HttpMethod.GET,
                new HttpEntity<>(gitHubConfig.getGitHubHeaders()), GitAdapterResponse[].class).getBody();
        return Arrays.asList(gitAPIResponse);
    }

}
