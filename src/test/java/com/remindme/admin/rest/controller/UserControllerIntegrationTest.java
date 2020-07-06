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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccessUserCreation() throws Exception {

        //Arrange
        UserRequest request = UserRequest.builder().firstName("sahil").
                surName("aggarwal").position("developer").gitHubProfileUrl("https://github.com/sahil5995").
                build();

        //Act and Assert
        mockMvc.perform(post("http://localhost:8090/user/create").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtil.convertObjectToJsonBytes(request))).
                andDo(print()).andExpect(status().isCreated());

    }

    @Test
    public void testInputValidation() throws Exception {

        //Arrange
        UserRequest request = UserRequest.builder().firstName("").
                surName("aggarwal").position("developer").gitHubProfileUrl("https://github.com/sahil5995").
                build();

        //Act and Assert
        mockMvc.perform(post("/user/create").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtil.convertObjectToJsonBytes(request))).
                andDo(print()).
                andExpect(jsonPath("$.firstName", is("First name can not be null.")));

    }

}
