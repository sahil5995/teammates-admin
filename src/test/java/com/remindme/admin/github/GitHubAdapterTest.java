package com.remindme.admin.github;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class GitHubAdapterTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GitHubAdapter underTest;

    @Mock
    private GitHubConfig gitHubConfig;

    @Test
    public void testGetRepositories() {

        Mockito.when(gitHubConfig.getGitHubAPIURL(anyString())).thenReturn("https://api.github.com/users/sahil5995/repos");
        Mockito.when(gitHubConfig.getUsernameFromURL(anyString())).thenReturn("sahil5995");

        GitAdapterResponse[] obj = new GitAdapterResponse[1];
        GitAdapterResponse res = new GitAdapterResponse();
        res.setProgrammingLanguage("java");
        res.setRepoLink("url");
        obj[0] = res;

        ResponseEntity<GitAdapterResponse[]> serviceResponse =
                new ResponseEntity<>(obj, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<GitAdapterResponse[]>>any()))
                .thenReturn(serviceResponse);

        List<GitAdapterResponse> result = underTest.getRepositories("https://github.com/sahil5995");

        Assert.assertEquals(1, result.size());
    }

}
