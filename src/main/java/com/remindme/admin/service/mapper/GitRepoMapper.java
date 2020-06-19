package com.remindme.admin.service.mapper;

import com.remindme.admin.github.GitAdapterResponse;
import com.remindme.admin.rest.response.GitHubRepoResponse;
import org.springframework.stereotype.Component;

@Component
public class GitRepoMapper {

    public GitHubRepoResponse mapAdapterToResponse(GitAdapterResponse adapter) {

        return GitHubRepoResponse.builder().repoLink(adapter.getRepoLink()).
                programmingLanguage(adapter.getProgrammingLanguage()).build();
    }
}
