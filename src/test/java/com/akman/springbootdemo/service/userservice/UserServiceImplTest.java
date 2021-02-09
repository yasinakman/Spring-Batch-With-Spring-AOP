package com.akman.springbootdemo.service.userservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserServiceImpl.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void test() {

    }
}