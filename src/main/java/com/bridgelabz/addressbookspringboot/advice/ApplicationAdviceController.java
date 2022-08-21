package com.bridgelabz.addressbookspringboot.advice;

import com.bridgelabz.addressbookspringboot.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationAdviceController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public Map<String,String> invalidAddress(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> errorMap=new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFound.class)
    public Map<String,String> userNotFound(UserNotFound userNotFound){
        Map<String,String> errrorMap=new HashMap<>();
        errrorMap.put("error-message",userNotFound.getMessage());
        return errrorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)

    public Map<String,String> anyOtherError(Exception exception){
        Map<String,String> errorMapping=new HashMap<>();
        errorMapping.put("error-message",exception.getMessage());
        return errorMapping;
    }




}
