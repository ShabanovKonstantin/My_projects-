package org.example.twitterspring.dto.request.user_dto;

import org.example.twitterspring.enums.UserType;

import java.time.LocalDate;

public class UserRegisterRequestDto {

    private String login;

    private String password;

    private String name;

    private String surname;

    private LocalDate dateOfBirth;

    private UserType userType;

    public UserRegisterRequestDto() {
    }

    public UserRegisterRequestDto(String login, String password, String name, String surname, LocalDate dateOFBirth, UserType userType) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOFBirth;
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOFBirth) {
        this.dateOfBirth = dateOFBirth;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
