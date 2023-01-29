package com.lewis.seasolutions.config.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {


    @ExceptionHandler(value = {NullPointerException.class})
    public String NullPointException()
    {
        return "candidate/error-not-found";
    }
    
}
