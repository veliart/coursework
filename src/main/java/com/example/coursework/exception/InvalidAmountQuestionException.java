package com.example.coursework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAmountQuestionException extends RuntimeException{
    public InvalidAmountQuestionException(String message) {
        super(message);
    }
}
