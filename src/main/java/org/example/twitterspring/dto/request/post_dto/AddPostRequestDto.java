package org.example.twitterspring.dto.request.post_dto;

public class AddPostRequestDto {

    private Long author;

    private String them;

    private String text;

    private String tags;

    public AddPostRequestDto() {
    }

    public AddPostRequestDto(Long author, String them, String text, String tags) {
        this.author = author;
        this.them = them;
        this.text = text;
        this.tags = tags;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
