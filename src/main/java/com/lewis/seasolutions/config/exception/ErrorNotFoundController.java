package com.lewis.seasolutions.config.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorNotFoundController implements ErrorController {
    private final static String PATH = "/error";

    @RequestMapping(PATH)
    public String getErrorPath() {
        return "candidate/error-not-found";
    }
}