package com.remindme.admin.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GitHubRepoResponse {

    private String repoLink;
    private String programmingLanguage;
}
