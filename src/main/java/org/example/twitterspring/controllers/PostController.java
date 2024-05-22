package org.example.twitterspring.controllers;

import org.example.twitterspring.dto.request.post_dto.AddPostRequestDto;
import org.example.twitterspring.dto.response.BaseResponseDto;
import org.example.twitterspring.dto.response.post_dto.AddPostResponseDto;
import org.example.twitterspring.dto.response.post_dto.PostResponseDto;
import org.example.twitterspring.entity.PostEntity;
import org.example.twitterspring.enums.UserType;
import org.example.twitterspring.exceptions.post.*;
import org.example.twitterspring.exceptions.user.UserNotFoundException;
import org.example.twitterspring.mappers.PostMapper;
import org.example.twitterspring.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/add-post")
    public BaseResponseDto<AddPostResponseDto> addPost(
            @RequestBody AddPostRequestDto addPostRequestDto
    ) {
        BaseResponseDto<AddPostResponseDto> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(
                    PostMapper.mapToAddPostResponseDto(
                    this.postService.addPost(
                            PostMapper.mapToPostEntityFromAddRequestDto(addPostRequestDto),
                            addPostRequestDto.getAuthor()
                            )
                    )
            );
        } catch (AddPostException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @GetMapping(value = "/my-posts/{id}")
    public BaseResponseDto<List<PostResponseDto>> getMyPosts(
            @PathVariable Long id
    ) {
        BaseResponseDto<List<PostResponseDto>> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(this.postService.myPosts(id).stream()
                    .map(PostMapper::mapToPostResponseDto)
                    .collect(Collectors.toList()));
        } catch (PostNotFoundException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @GetMapping(value = "/all-posts")
    public BaseResponseDto<List<PostResponseDto>> getAllPosts() {
        BaseResponseDto<List<PostResponseDto>> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(this.postService.allPosts().stream()
                    .map(PostMapper::mapToPostResponseDto)
                    .collect(Collectors.toList()));
        } catch (PostNotFoundException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @PostMapping(value = "/posts-by-tag")
    public BaseResponseDto<List<PostResponseDto>> getPostsByTag(
            @RequestParam String tag
    ) {
        BaseResponseDto<List<PostResponseDto>> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(this.postService.postsByTag(tag).stream()
                    .map(PostMapper::mapToPostResponseDto)
                    .collect(Collectors.toList()));
        } catch (FindPostByTagException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        } catch (PostNotFoundException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @PostMapping(value = "/posts-by-login")
    public BaseResponseDto<List<PostResponseDto>> getPostsByLogin(
            @RequestParam String login
    ) {
        BaseResponseDto<List<PostResponseDto>> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(this.postService.postsByLogin(login).stream()
                    .map(PostMapper::mapToPostResponseDto)
                    .collect(Collectors.toList()));
        } catch (FindPostByLoginException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        } catch (PostNotFoundException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @PostMapping(value = "/posts-by-user-type")
    public BaseResponseDto<List<PostResponseDto>> getPostsByUserType(
            @RequestParam UserType userType
    ) {
        BaseResponseDto<List<PostResponseDto>> baseResponseDto = new BaseResponseDto<>();

        try {
            baseResponseDto.setStatus("OK");
            baseResponseDto.setMessage("successful");
            baseResponseDto.setData(this.postService.postsByUserType(userType).stream()
                    .map(PostMapper::mapToPostResponseDto)
                    .collect(Collectors.toList()));
        } catch (FindPostByUserTypeException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        } catch (PostNotFoundException e) {
            baseResponseDto.setStatus("FAIL");
            baseResponseDto.setMessage(e.getLocalizedMessage());
        }

        return baseResponseDto;
    }

    @PostMapping(value = "/test")
    public PostResponseDto test(
            @RequestBody AddPostRequestDto addPostRequestDto
    ) {
        PostResponseDto postResponseDto = new PostResponseDto();
        return postResponseDto;
    }
}
