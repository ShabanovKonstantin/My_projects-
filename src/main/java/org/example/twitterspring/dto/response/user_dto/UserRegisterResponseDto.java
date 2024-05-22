package org.example.twitterspring.dto.response.user_dto;

public class UserRegisterResponseDto {

    private Long id;

    private String login;

    public UserRegisterResponseDto() {
    }

    public UserRegisterResponseDto(Long id, String login) {
        this.id = id;
        this.login = login;
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
