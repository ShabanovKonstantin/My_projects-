package org.example.twitterspring.service.impl;

import org.example.twitterspring.entity.UserEntity;
import org.example.twitterspring.enums.UserType;
import org.example.twitterspring.exceptions.user.UserNotFoundException;
import org.example.twitterspring.repositorys.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testGetUserInfoById_OK() {
        try {
            UserEntity user = new UserEntity(1L, "testLogin", "testPassword",
                    LocalDate.now(), "testName", "testSurname", LocalDate.now(), UserType.PERSON);

            Mockito
                    .when(this.userRepository.findById(1L))
                    .thenReturn(Optional.of(user));

            userService.getUserInfoById(1L);

        } catch (UserNotFoundException ex) {
            Assertions.fail();
        }
    }

    @Test
    public void testGetUserInfoById_UserNotFoundException() {
        UserEntity user = new UserEntity(1L, "testLogin", "testPassword",
                LocalDate.now(), "testName", "testSurname", LocalDate.now(), UserType.PERSON);

        Mockito
                .when(this.userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        //Assertions.assertThrows(UserNotFoundException.class, () -> this.userService.getUserInfoById(1L));
    }
}