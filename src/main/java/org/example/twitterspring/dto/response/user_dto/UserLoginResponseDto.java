package org.example.twitterspring.dto.response.user_dto;

public class UserLoginResponseDto {

    private Long id;

    private String login;

    public UserLoginResponseDto() {
    }

    public UserLoginResponseDto(String login, Long id) {
        this.login = login;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
