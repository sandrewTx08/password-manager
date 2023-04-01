package com.passwordmanager.advices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleBusinessException(Exception exception) {
        Map<String, String> errorMap = new HashMap<String, String>();
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }
}
