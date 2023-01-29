package com.lewis.seasolutions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CandidateController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudents() {
        return "candidate/candidate-list";
    }
}
