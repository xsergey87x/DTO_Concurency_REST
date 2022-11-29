package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "There isn`t such teacher in the base")
public class NoSuchElementException extends RuntimeException{

    public NoSuchElementException(String message) {
        super(message);
        System.out.println(message);
    }
}
