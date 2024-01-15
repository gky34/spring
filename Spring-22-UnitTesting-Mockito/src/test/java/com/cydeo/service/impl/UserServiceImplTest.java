package com.cydeo.service.impl;

import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    @Test
    void deleteByUserName_test() {

        userService.deleteByUserName("mikesmith@cydeo.com");

        /**
         *  Mockito.verify -> make sure that user repo delete by username with this user name run
         */
        Mockito.verify(userRepository).deleteByUserName("mikesmith@cydeo.com");

//        verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
        verify(userRepository).findAll();
//        verify(userRepository, times(2)).deleteByUserName("mikesmith@cydeo.com");
        verify(userRepository, atLeastOnce()).deleteByUserName("mikesmith@cydeo.com");
        verify(userRepository, atLeast(2)).deleteByUserName("mikesmith@cydeo.com");
        verify(userRepository, atMostOnce()).deleteByUserName("mikesmith@cydeo.com");
        verify(userRepository, atMost(5)).deleteByUserName("mikesmith@cydeo.com");

        /**
         *  It comes from mokito
         */
        InOrder inOrder = inOrder(userRepository);

        inOrder.verify(userRepository).deleteByUserName("mikesmith@cydeo.com");
        inOrder.verify(userRepository).findAll();
    }


}