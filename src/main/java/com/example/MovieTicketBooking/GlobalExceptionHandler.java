package com.example.MovieTicketBooking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleGenericException(Exception exception){
        return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_GATEWAY);
    }
}
