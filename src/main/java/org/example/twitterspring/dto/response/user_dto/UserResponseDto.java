package org.example.twitterspring.dto.response.user_dto;

import org.example.twitterspring.enums.UserType;

import java.time.LocalDate;

public class UserResponseDto {

    private UserType userType;
    private String login;
    private String name;
    private String surname;
    private LocalDate dateCreate;
    private Long id;

    public UserResponseDto() {
    }

    public UserResponseDto(UserType userType, String login, String name, String surname, LocalDate dateCreate, Long id) {
        this.userType = userType;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.dateCreate = dateCreate;
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
