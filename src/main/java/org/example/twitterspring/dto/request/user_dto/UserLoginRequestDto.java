package org.example.twitterspring.dto.request.user_dto;

public class UserLoginRequestDto {

    private String login;

    private String password;

    public UserLoginRequestDto() {
    }

    public UserLoginRequestDto(String login, String password) {
        this.login = login;
        this.password = password;
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
}
