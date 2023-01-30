package com.lewis.seasolutions.controller;

import com.lewis.seasolutions.config.CandidateConvert;
import com.lewis.seasolutions.domain.dtos.CandidateDTO;
import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.domain.entities.Role;
import com.lewis.seasolutions.domain.entities.StateCode;
import com.lewis.seasolutions.domain.models.CandidateModel;
import com.lewis.seasolutions.domain.models.RoleModel;
import com.lewis.seasolutions.domain.models.StateCodeModel;
import com.lewis.seasolutions.services.contracts.CandidateService;
import com.lewis.seasolutions.services.contracts.RoleService;
import com.lewis.seasolutions.services.contracts.StateCodeService;
import org.modelmapper.ModelMapper;
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
    private RoleService roleService;
    @Autowired
    private StateCodeService stateCodeService;
    @Autowired
    private CandidateConvert candidateConvert;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/candidate/create")
    public String create(Model theModel)
    {
         CandidateModel candidateModel = new CandidateModel();
         candidateModel = addPropertiesToCandidateModel(candidateModel);

        theModel.addAttribute("candidate", candidateModel);
        return "candidate/candidate-create";
    }
    private CandidateModel addPropertiesToCandidateModel(CandidateModel candidateModel)
    {
        List<Role> roles = roleService.findAll();
        List<StateCode> stateCodes = stateCodeService.findAll();

        List<RoleModel> roleModelList = candidateConvert.toListRoleModel(roles);
        List<StateCodeModel> stateCodeModelList = candidateConvert.toListStateCodeModel(stateCodes);
        candidateModel.setRoles(roleModelList);
        candidateModel.setStateCodes(stateCodeModelList);
        return candidateModel;
    }

    @PostMapping("candidate/createdCandidate")
    public String save(@ModelAttribute("candidate") CandidateModel candidateModel)
    {
        Candidate candidate = convertCandidateModelToEntity(candidateModel);
        candidateService.saveOrUpdate(candidate);
        return "redirect:/";
    }

    private Candidate convertCandidateModelToEntity(CandidateModel candidateModel)
    {
        Role role = roleService.findById(candidateModel.getRoleId());
        StateCode stateCode = stateCodeService.findById(candidateModel.getStateCodeId());
        Candidate candidate = mapper.map(candidateModel, Candidate.class);
        candidate.setRole(role);
        candidate.setStateCode(stateCode);
        return candidate;
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

    @GetMapping(value = "/candidate/{id}/update")
    public String update(@PathVariable Long id, Model theModel)
    {
        Candidate candidate = candidateService.findById(id);
        CandidateModel candidateModel = mapper.map(candidate, CandidateModel.class);
        candidateModel = addPropertiesToCandidateModel(candidateModel);
        theModel.addAttribute("candidate", candidateModel);
        return "candidate/candidate-update";
    }

    @PostMapping("candidate/updatedCandidate")
    public String update(@ModelAttribute("candidate") CandidateModel candidateModel)
    {
        Candidate candidate = convertCandidateModelToEntity(candidateModel);
        candidateService.saveOrUpdate(candidate);
        return "redirect:/";
    }

    @GetMapping("/candidate/{id}/delete")
    public String delete(@PathVariable Long id, Model model)
    {
        candidateService.delete(id);
        return "redirect:/";
    }
}
