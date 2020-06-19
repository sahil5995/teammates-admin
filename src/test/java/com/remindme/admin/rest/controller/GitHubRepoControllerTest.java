package com.remindme.admin.rest.controller;

import com.remindme.admin.rest.request.UserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GitHubRepoControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testSuccess() throws Exception {

        //Arrange
        UserRequest request = UserRequest.builder().firstName("sahil").
                surName("aggarwal").position("developer").gitHubProfileUrl("https://github.com/sahil5995").
                build();
        mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtil.convertObjectToJsonBytes(request)));


        //Act and Assert
        mockMvc.perform(get("/users/{userId}/repositories", 1L).contentType(MediaType.APPLICATION_JSON_VALUE)
        ).
                andDo(print()).andExpect(status().isOk()).
                andExpect(jsonPath("$[0].repoLink").exists()).
                andExpect(jsonPath("$[0].programmingLanguage").exists());
    }

    @Test
    public void testInputValidation() throws Exception {

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/repositories", 1L).
                contentType(MediaType.APPLICATION_JSON_VALUE)).
                andExpect(jsonPath("$.message", is("User with id 1 not found")));
    }


}
