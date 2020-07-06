package com.remindme.admin.rest.controller;

import com.remindme.admin.rest.request.UserRequest;
import com.remindme.admin.rest.response.UserResponse;
import com.remindme.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {

        UserResponse res = UserResponse.builder().surName("agg").firstName("first")
                .position("java").githubProfileUrl("https://github.com/sahil5995").build();

        UserRequest req = UserRequest.builder().surName("agg").firstName("first")
                .position("java").gitHubProfileUrl("https://github.com/sahil5995").build();

        //given(service.createUser(any())).willReturn(res);
        when(service.createUser(any(UserRequest.class))).thenReturn(res);

        //Act and Assert
        mockMvc.perform(post("http://localhost:8090/user/create").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestUtil.convertObjectToJsonBytes(req))).
                andDo(print()).andExpect(status().isCreated());

        verify(service, times(1)).createUser(any(UserRequest.class));

    }

}
