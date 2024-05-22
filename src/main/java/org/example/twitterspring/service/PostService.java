package org.example.twitterspring.service;

import org.example.twitterspring.entity.PostEntity;
import org.example.twitterspring.entity.UserEntity;
import org.example.twitterspring.enums.UserType;
import org.example.twitterspring.exceptions.post.*;
import org.example.twitterspring.exceptions.user.UserNotFoundException;

import java.util.List;

public interface PostService {

    PostEntity addPost(PostEntity postEntity, Long author) throws AddPostException, UserNotFoundException;

    List<PostEntity> myPosts(Long id) throws PostNotFoundException;

    List<PostEntity> allPosts() throws PostNotFoundException;

    List<PostEntity> postsByTag(String tag) throws FindPostByTagException, PostNotFoundException;

    List<PostEntity> postsByLogin(String login) throws FindPostByLoginException, PostNotFoundException;

    List<PostEntity> postsByUserType(UserType userType) throws FindPostByUserTypeException, PostNotFoundException;
}