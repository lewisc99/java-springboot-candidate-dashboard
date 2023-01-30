package com.lewis.seasolutions.config.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MvcExceptionHandler {


    @ExceptionHandler(value = {NullPointerException.class})
    public String NullPointException()
    {
        return "candidate/error-not-found";
    }

    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
    public String EmptyResultDataAccessException()
    {
        return "candidate/error-not-found";
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public String NotFound()
    {
        return "candidate/error-not-found";
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public String illegalArgumentException()
    {
        return "candidate/error-not-found";
    }
}
