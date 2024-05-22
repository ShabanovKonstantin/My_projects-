package org.example.twitterspring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.twitterspring.entity.UserEntity;
import org.example.twitterspring.enums.UserType;
import org.example.twitterspring.exceptions.user.*;
import org.example.twitterspring.repositorys.UserRepository;
import org.example.twitterspring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity) throws InvalidRegisterUserException {
        if (Objects.isNull(userEntity.getLogin()) || userEntity.getLogin().trim().isEmpty()) {
            throw new InvalidRegisterUserException("Вы не ввели логин!");
        }

        if (Objects.isNull(userEntity.getPassword()) || userEntity.getPassword().trim().isEmpty()) {
            throw new InvalidRegisterUserException("Вы не ввели пароль!");
        }

        if (Objects.isNull(userEntity.getName()) || userEntity.getName().trim().isEmpty()) {
            throw new InvalidRegisterUserException("Вы не ввели имя!");
        }

        if (Objects.isNull(userEntity.getSurname()) || userEntity.getSurname().trim().isEmpty()) {
            throw new InvalidRegisterUserException("Вы не ввели фамилию!");
        }

        if (Objects.isNull(userEntity.getDateBirth())) {
            throw new InvalidRegisterUserException("Вы не ввели дату рождения!");
        }

        if (userEntity.getUserType().equals(UserType.PERSON)) {
            if (userEntity.getDateBirth().isAfter(LocalDate.now())) {
                throw new InvalidRegisterUserException("Вы указали не существуюшую дату!");
            }

            if (userEntity.getDateBirth().isAfter(LocalDate.parse("2014-01-01"))) {
                throw new InvalidRegisterUserException("Извините вы не достигли необходимого возроста!");
            }
        } else {
            if (userEntity.getDateBirth().isBefore(LocalDate.parse("1950-01-01"))) {
                throw new InvalidRegisterUserException("Извините вы ввели слишком познюю дату!");
            }
        }

        if (Objects.isNull(userEntity.getUserType())) {
            throw new InvalidRegisterUserException("Вы не ввели тип пользователя!");
        }

        this.userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity login(String login, String password) throws InvalidLoginException, InvalidAuthorizationException {
        UserEntity user = this.userRepository.findByLogin(login);

        if (Objects.isNull(user)) {
            throw new InvalidLoginException("Пользователя с таким логином не существует!");
        }

        if (!user.getPassword().equals(password)) {
            throw new InvalidAuthorizationException("Логин и/или пароль не верен!");
        }

        return user;
    }

    @Override
    public UserEntity getUserInfoById(Long id) throws UserNotFoundException {

        return this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Пользователь не найден!"));
    }

    @Override
        public UserEntity getUserInfoByLogin(String login) throws UserInfoException {
        if (Objects.isNull(this.userRepository.findByLogin(login))) {
            this.logger.getName();
            throw new UserInfoException("Не найдено пользователя с таким логином!");
        }

        return this.userRepository.findByLogin(login);
    }

    @Override
    public List<UserEntity> getAllUsers() throws UserNotFoundException {
        if (this.userRepository.findAll().isEmpty()) {
            throw new UserNotFoundException("В системе нет пользователей!");
        }

        return this.userRepository.findAll();
    }
}
