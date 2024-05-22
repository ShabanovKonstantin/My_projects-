package org.example.twitterspring.controllers.advice;

import org.example.twitterspring.dto.response.BaseResponseDto;
import org.example.twitterspring.dto.response.user_dto.UserResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResponseDto<UserResponseDto> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new BaseResponseDto<UserResponseDto>("FAIL", ex.getLocalizedMessage(), null);
    }
}
