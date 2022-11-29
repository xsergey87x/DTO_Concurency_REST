package com.example.demo.exception.hangler;

import com.example.demo.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
    private String BAD_REQUEST = "BAD_REQUEST";


    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity handleUserNotFoundException
            (RecordNotFoundException ex, WebRequest request)
    {
        return new ResponseEntity<>("Teacher with specified id not found", HttpStatus.NOT_FOUND);
    }
}
