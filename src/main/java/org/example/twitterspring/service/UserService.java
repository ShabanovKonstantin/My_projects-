package org.example.twitterspring.service;

import org.example.twitterspring.entity.UserEntity;
import org.example.twitterspring.exceptions.user.*;

import java.util.List;

public interface UserService {

    UserEntity registerUser(UserEntity userEntity) throws InvalidRegisterUserException;

    UserEntity login(String login, String password) throws InvalidLoginException, InvalidAuthorizationException;

    /**
     * Метод для получения пользователя по его id
     * @param id по которому будет произведен поиск пользователя
     * @return Возрощает найденого пользователя
     * @throws UserNotFoundException - выдаёт сообщение в случае если пользователь не был найден
     */
    UserEntity getUserInfoById(Long id) throws UserNotFoundException;

    UserEntity getUserInfoByLogin(String login) throws UserInfoException;

    List<UserEntity> getAllUsers() throws UserNotFoundException;

}
