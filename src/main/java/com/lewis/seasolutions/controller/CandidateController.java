package com.lewis.seasolutions.controller;

import com.lewis.seasolutions.config.CandidateConvert;
import com.lewis.seasolutions.domain.dtos.CandidateDTO;
import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.domain.models.CandidateModel;
import com.lewis.seasolutions.services.contracts.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateConvert candidateConvert;


    @GetMapping(value = "/candidate/create")
    public String create(Model theModel)
    {
        CandidateModel candidateModel = new CandidateModel();
        theModel.addAttribute("candidate", candidateModel);
        return "candidate-create";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Model model) {

        List<Candidate> candidates = candidateService.findAll();
        List<CandidateDTO> candidateDTOS = candidateConvert.toListCandidateDTO(candidates);
        model.addAttribute("candidates",candidateDTOS);
        return "candidate/candidate-list";
    }

    @GetMapping("/candidate/{id}")
    public String getById(@PathVariable Long id, Model model) {

        Candidate candidate = candidateService.findById(id);
        CandidateDTO candidateDTO = candidateConvert.toCandidateDTO(candidate);
        model.addAttribute("candidate",candidateDTO);
        return "candidate/candidate-by-id";
    }

    @GetMapping("/candidate/{id}/delete")
    public String delete(@PathVariable Long id, Model model)
    {
        candidateService.delete(id);
        return "redirect:/";
    }
}
