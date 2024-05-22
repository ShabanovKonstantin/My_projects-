package org.example.twitterspring.mappers;

import org.example.twitterspring.dto.request.user_dto.UserLoginRequestDto;
import org.example.twitterspring.dto.request.user_dto.UserRegisterRequestDto;
import org.example.twitterspring.dto.response.user_dto.UserLoginResponseDto;
import org.example.twitterspring.dto.response.user_dto.UserRegisterResponseDto;
import org.example.twitterspring.dto.response.user_dto.UserResponseDto;
import org.example.twitterspring.entity.UserEntity;

import java.time.LocalDate;

public class UserMapper {

    public static UserEntity mapToEntityFromUserRegisterRequestDto(UserRegisterRequestDto userRegisterRequestDto) {
        UserEntity user = new UserEntity();
        user.setLogin(userRegisterRequestDto.getLogin());
        user.setPassword(userRegisterRequestDto.getPassword());
        user.setName(userRegisterRequestDto.getName());
        user.setSurname(userRegisterRequestDto.getSurname());
        user.setDateBirth(userRegisterRequestDto.getDateOfBirth());
        user.setUserType(userRegisterRequestDto.getUserType());
        user.setDateCreate(LocalDate.now());

        return user;
    }

    public static UserLoginResponseDto mapToLoginResponseFromUserLoginRequestDto(UserEntity userEntity) {
        UserLoginResponseDto user = new UserLoginResponseDto();
        user.setId(userEntity.getId());
        user.setLogin(userEntity.getLogin());

        return user;
    }

    public static UserRegisterResponseDto mapToRegisterResponseFromUserLoginRequestDto(UserEntity userEntity) {
        UserRegisterResponseDto user = new UserRegisterResponseDto();
        user.setId(userEntity.getId());
        user.setLogin(userEntity.getLogin());

        return user;
    }

    public static UserResponseDto mapToUserResponseDtoForGetAllInformativeMethods(UserEntity userEntity) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(userEntity.getId());
        userResponseDto.setLogin(userEntity.getLogin());
        userResponseDto.setName(userEntity.getName());
        userResponseDto.setSurname(userEntity.getSurname());
        userResponseDto.setDateCreate(userEntity.getDateCreate());
        userResponseDto.setUserType(userEntity.getUserType());

        return userResponseDto;
    }
}
