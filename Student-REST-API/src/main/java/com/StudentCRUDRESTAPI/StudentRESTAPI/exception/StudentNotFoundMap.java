package com.StudentCRUDRESTAPI.StudentRESTAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice

public class StudentNotFoundMap {
//if exception is found then its response to the handler
    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    //all exception will be extracted  into map
    public Map<String,String> exceptionHandler(StudentNotFoundException exception){
        Map<String,String> error=new HashMap<>();
        error.put("Error",exception.getMessage());
        return error;
    }
}
