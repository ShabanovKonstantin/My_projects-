package org.example.twitterspring.controllers;

import org.example.twitterspring.dto.request.user_dto.UserLoginRequestDto;
import org.example.twitterspring.dto.request.user_dto.UserRegisterRequestDto;
import org.example.twitterspring.dto.response.BaseResponseDto;
import org.example.twitterspring.dto.response.user_dto.UserLoginResponseDto;
import org.example.twitterspring.dto.response.user_dto.UserRegisterResponseDto;
import org.example.twitterspring.dto.response.user_dto.UserResponseDto;
import org.example.twitterspring.entity.UserEntity;
import org.example.twitterspring.exceptions.user.*;
import org.example.twitterspring.mappers.UserMapper;
import org.example.twitterspring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping(value = "/register-user")
    public BaseResponseDto<UserRegisterResponseDto> registerUser(
            @RequestBody UserRegisterRequestDto userRegisterRequestDto
    ) {
       BaseResponseDto<UserRegisterResponseDto> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(
                    UserMapper.mapToRegisterResponseFromUserLoginRequestDto(
                            this.userServiceImpl.registerUser(
                                    UserMapper.mapToEntityFromUserRegisterRequestDto(userRegisterRequestDto)
                            )
                    )
            );
        } catch (InvalidRegisterUserException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @PostMapping(value = "/login")
    public BaseResponseDto<UserLoginResponseDto> userLogin(
            @RequestBody UserLoginRequestDto userLoginRequestDto
            ) {
        BaseResponseDto<UserLoginResponseDto> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(UserMapper.mapToLoginResponseFromUserLoginRequestDto(
                    this.userServiceImpl.login(userLoginRequestDto.getLogin(), userLoginRequestDto.getPassword())));
        } catch (InvalidLoginException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        } catch (InvalidAuthorizationException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @GetMapping(value = "/all-users")
    public BaseResponseDto<List<UserResponseDto>> getAllUsers() {
        BaseResponseDto<List<UserResponseDto>> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(this.userServiceImpl.getAllUsers().stream()
                    .map(UserMapper::mapToUserResponseDtoForGetAllInformativeMethods)
                    .collect(Collectors.toList()));
        } catch (UserNotFoundException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @GetMapping(value = "/user-info-by-id")
    public BaseResponseDto<UserResponseDto> getUserInfoById(
            @RequestParam(required = false) Long id
    ) {
        BaseResponseDto<UserResponseDto> userResponseDto = new BaseResponseDto<>();

        try {
            userResponseDto.setStatus("OK");
            userResponseDto.setMessage("successful");
            userResponseDto.setData(UserMapper.mapToUserResponseDtoForGetAllInformativeMethods(this.userServiceImpl.getUserInfoById(id)));
        } catch (UserNotFoundException e) {
            userResponseDto.setStatus("FAIL");
            userResponseDto.setMessage(e.getLocalizedMessage());
        }

        return userResponseDto;
    }

    @GetMapping(value = "/user-info-by-login/{login}")
    public BaseResponseDto<UserResponseDto> getUserInfoByLogin(
            @PathVariable String login
    ) {
        BaseResponseDto<UserResponseDto> userResponseDto = new BaseResponseDto<>();

        try {
            userResponseDto.setStatus("OK");
            userResponseDto.setMessage("successful");
            userResponseDto.setData(UserMapper.mapToUserResponseDtoForGetAllInformativeMethods(this.userServiceImpl.getUserInfoByLogin(login)));
        } catch (UserInfoException e) {
            userResponseDto.setStatus("FAIL");
            userResponseDto.setMessage(e.getLocalizedMessage());
        }

        return userResponseDto;
    }

    public UserEntity getUserByLogin(String login) {
        try {
            return this.userServiceImpl.getUserInfoByLogin(login);
        } catch (UserInfoException e) {
            throw new RuntimeException(e);
        }
    }
}
