package org.example.twitterspring.service.impl;

import org.example.twitterspring.entity.PostEntity;
import org.example.twitterspring.enums.UserType;
import org.example.twitterspring.exceptions.post.*;
import org.example.twitterspring.exceptions.user.UserNotFoundException;
import org.example.twitterspring.repositorys.PostRepository;
import org.example.twitterspring.service.PostService;
import org.hibernate.annotations.AnyDiscriminatorValue;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final UserServiceImpl userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserServiceImpl userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public PostEntity addPost(PostEntity postEntity, Long author) throws AddPostException {
        if (Objects.isNull(author)) {
            throw new AddPostException("Вы не ввели автрора!");
        }

        if (Objects.isNull(postEntity.getThem()) || postEntity.getThem().trim().isEmpty()) {
            throw new AddPostException("Вы не ввели тему поста!");
        }

        if (Objects.isNull(postEntity.getText()) || postEntity.getText().trim().isEmpty()) {
            throw new AddPostException("Вы не ввели текст поста!");
        }

        if (Objects.isNull(postEntity.getTags()) || postEntity.getTags().isEmpty()) {
            throw new AddPostException("Вы не ввели теги поста!");
        }

        try {
            postEntity.setAuthor(this.userService.getUserInfoById(author));
        } catch (UserNotFoundException e) {
            throw new AddPostException(e.getLocalizedMessage());
        }
        this.postRepository.save(postEntity);
        return postEntity;
    }

    @Override
    public List<PostEntity> myPosts(Long id) throws PostNotFoundException {
        if (this.postRepository.findPostEntitiesByAuthor_Id(id).isEmpty()) {
            throw new PostNotFoundException("Не найдено постов у этого пользователя!");
        }

        return this.postRepository.findPostEntitiesByAuthor_Id(id);
    }

    @Override
    public List<PostEntity> allPosts() throws PostNotFoundException {
        if (this.postRepository.findAll().isEmpty()) {
            throw new PostNotFoundException("В системе нет постов!");
        }

        return this.postRepository.findAll();
    }

    @Override
    public List<PostEntity> postsByTag(String tag) throws FindPostByTagException, PostNotFoundException {
        if (Objects.isNull(tag) || tag.trim().isEmpty()) {
            throw new FindPostByTagException("Вы не ввели тег поста!");
        }

        if (this.postRepository.findAll().isEmpty()) {
            throw new PostNotFoundException("В системе нет постов!");
        }

        if (this.postRepository.getPostEntitiesByTag(tag).isEmpty()) {
            throw new PostNotFoundException("В системе нет постов с таким тегом!");
        }

        return this.postRepository.getPostEntitiesByTag(tag);
    }

    @Override
    public List<PostEntity> postsByLogin(String login) throws FindPostByLoginException, PostNotFoundException {
        if (Objects.isNull(login) || login.trim().isEmpty()) {
            throw new FindPostByLoginException("Вы не ввели логин!");
        }

        if (this.postRepository.findPostEntitiesByAuthor_Login(login).isEmpty()) {
            throw new PostNotFoundException("У данного пользователя не найдено постов!");
        }

        return this.postRepository.findPostEntitiesByAuthor_Login(login);
    }

    @Override
    public List<PostEntity> postsByUserType(UserType userType) throws FindPostByUserTypeException, PostNotFoundException {
        if (userType == null) {
            throw new FindPostByUserTypeException("Вы не ввели тип пользователя!");
        }

        if (!UserType.PERSON.equals(userType) && !UserType.ORGANIZATION.equals(userType)) {
            throw new FindPostByUserTypeException("Вы ввели некоректный тип пользователя!");
        }

        if (this.postRepository.findPostEntitiesByAuthor_UserType(userType).isEmpty()) {
            throw new PostNotFoundException("Пользователи данного типа не сделали постов!");
        }

        return this.postRepository.findPostEntitiesByAuthor_UserType(userType);
    }
}
