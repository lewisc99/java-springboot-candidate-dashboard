package com.lewis.seasolutions.controller;

import com.lewis.seasolutions.config.CandidateConvert;
import com.lewis.seasolutions.domain.dtos.CandidateDTO;
import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.services.contracts.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateConvert candidateConvert;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudents(Model model) {

        List<Candidate> candidates = candidateService.findAll();
        List<CandidateDTO> candidateDTOS = candidateConvert.toCandidateDTO(candidates);
        model.addAttribute("candidates",candidateDTOS);
        return "candidate/candidate-list";
    }
}
