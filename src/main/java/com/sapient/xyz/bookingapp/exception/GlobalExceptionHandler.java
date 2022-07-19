package com.sapient.xyz.bookingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleAnyException(HttpServletRequest req, Exception e){
        e.printStackTrace();
        UUID uuid = UUID.randomUUID();
        ResponseError responseError = new ResponseError(e.getMessage(), uuid);
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
}
