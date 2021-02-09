package com.akman.springbootdemo.rest_api.controller;

import com.akman.springbootdemo.service.userservice.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(UserController.class)
@RunWith(PowerMockRunner.class)
public class UserControllerTest {

    private static final String USER_ENDPOINT = "/api/v1/user/";

    private MockMvc mvc;

    private ObjectMapper objectMapper;

    @Mock
    private UserService userService;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mvc = MockMvcBuilders
                .standaloneSetup(new UserController(userService))
                .build();
    }

    @Test
    public void test() {

    }
}