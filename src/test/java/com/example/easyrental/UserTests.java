package com.example.easyrental;

import com.example.easyrental.controller.UserController;
import com.example.easyrental.dao.ProductRepository;
import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserTests {

    @Autowired
    UserController userController;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginTest(){
        Map<String, Object> payload= new HashMap<>();
        payload.put("email","abc@gmail.com");
        payload.put("password","1");
        when(userRepository.findByEmail(any())).thenReturn(null);
        String message = userController.login(payload);
        Assert.assertEquals("Invalid",message);
    }

}
