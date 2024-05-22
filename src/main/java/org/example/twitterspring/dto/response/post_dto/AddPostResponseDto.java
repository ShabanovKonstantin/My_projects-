package org.example.twitterspring.dto.response.post_dto;

public class AddPostResponseDto {

    private Long id;

    private String them;

    public AddPostResponseDto() {
    }

    public AddPostResponseDto(Long id, String them) {
        this.id = id;
        this.them = them;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }
}
