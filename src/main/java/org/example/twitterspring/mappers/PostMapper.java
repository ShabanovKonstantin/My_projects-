package org.example.twitterspring.mappers;

import org.example.twitterspring.dto.request.post_dto.AddPostRequestDto;
import org.example.twitterspring.dto.response.post_dto.AddPostResponseDto;
import org.example.twitterspring.dto.response.post_dto.PostResponseDto;
import org.example.twitterspring.entity.PostEntity;
import org.example.twitterspring.entity.UserEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostMapper {

    public static PostEntity mapToPostEntityFromAddRequestDto(AddPostRequestDto addPostRequestDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setThem(addPostRequestDto.getThem());
        postEntity.setText(addPostRequestDto.getText());
        postEntity.setDateCreate(LocalDate.now());
        String[] tags = addPostRequestDto.getTags().split(" ");
        List<String> tagsList = new ArrayList<>();
        for (int i = 0; i < tags.length; i++) {
            tagsList.add(tags[i]);
        }

        postEntity.setTags(tagsList);

        return postEntity;
    }
    public static PostResponseDto mapToPostResponseDto(PostEntity postEntity) {
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setId(postEntity.getId());
        postResponseDto.setThem(postEntity.getThem());
        postResponseDto.setText(postEntity.getText());
        postResponseDto.setDateCreate(postEntity.getDateCreate());
        postResponseDto.setAuthor(postEntity.getAuthor().getId());
        postResponseDto.setTags(postEntity.getTags());

        return postResponseDto;
    }

    public static AddPostResponseDto mapToAddPostResponseDto(PostEntity postEntity) {
        AddPostResponseDto addPostResponseDto = new AddPostResponseDto();
        addPostResponseDto.setId(postEntity.getId());
        addPostResponseDto.setThem(postEntity.getThem());

        return addPostResponseDto;
    }
}
