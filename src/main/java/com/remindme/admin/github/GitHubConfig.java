package com.remindme.admin.github;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Optional;

@Component
public class GitHubConfig {

    @Value("${github.repoBaseUrl}")
    private String repoBaseUrl;

    @Value("${github.authToken}")
    private String authToken;


    public HttpHeaders getGitHubHeaders() {

        byte[] token = Base64.getDecoder().decode(authToken);
        return new HttpHeaders() {{
            set("Authorization", "token " + new String(token));
        }};
    }

    public String getGitHubAPIURL(String username) {
        return repoBaseUrl + username + "/repos";
    }

    public String getUsernameFromURL(String gitHubProfileUrl) {
        try {
            String username = new URL(gitHubProfileUrl).getPath();
            return Optional.ofNullable(username)
                    .filter(str -> str.endsWith("/"))
                    .map(sStr -> sStr.substring(0, sStr.length() - 1))
                    .orElse(username);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Incorrect GitHub URL");
        }
    }
}
