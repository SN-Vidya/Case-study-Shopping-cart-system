package com.shoppingcartsystem.profileservice.service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shoppingcartsystem.profileservice.model.User;
import com.shoppingcartsystem.profileservice.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    private final String _id = "1001";
    private final String FULL_NAME = "test";
    private User user;
    private List<User> userList;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp(){
        user = new User();
        user.set_id(_id);
        user.setFullName(FULL_NAME);
        userList = new ArrayList<>();
        userList.add(user);
    }

    @Test
    public void get_all_users_test(){
        // given
        when(userRepository.findAll()).thenReturn(userList);

        // when
        List<User> foundUsers = userService.getAllUser();

        // then
        assertEquals(foundUsers.get(0).getFullName(),FULL_NAME);
        Mockito.verify(userRepository, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    
    @Test
    public void get_user_by_id_test(){
        // given
        when(userRepository.getOne(anyString())).thenReturn(user);

        // when
        User foundUser = userService.getUserById(_id);

        // then
        assertEquals(foundUser.getFullName(), FULL_NAME);
        Mockito.verify(userRepository, Mockito.times(1)).getOne(anyString());
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void get_user_by_name_test(){
        // given
        when(userRepository.findByFullName(anyString())).thenReturn(user);

        // when
        User foundUser = userService.getByFullName(FULL_NAME);

        // then
        assertEquals(foundUser.get_id(), userList);
        Mockito.verify(userRepository, Mockito.times(1)).findByFullName(FULL_NAME);
        Mockito.verifyNoMoreInteractions(userRepository);
    }
}
