package com.lewis.seasolutions.config;

import com.lewis.seasolutions.domain.dtos.CandidateDTO;
import com.lewis.seasolutions.domain.entities.StateCode;
import com.lewis.seasolutions.domain.models.RoleModel;
import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.domain.entities.Role;
import com.lewis.seasolutions.domain.models.StateCodeModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateConvert {

    @Autowired
    private ModelMapper modelMapper;

    public List<CandidateDTO> toListCandidateDTO(List<Candidate> candidatesEntity) {
        List<CandidateDTO> candidatesDTOS = new ArrayList<>();
        for(Candidate candidate: candidatesEntity)
        {
            CandidateDTO candidateDTO = modelMapper.map(candidate, CandidateDTO.class);

            candidatesDTOS.add(candidateDTO);
        }
        return candidatesDTOS;
    }

    public List<RoleModel> toListRoleModel(List<Role> rolesEntity) {
        List<RoleModel> RoleModels = new ArrayList<>();
        for(Role role: rolesEntity)
        {
            RoleModel RoleModel = modelMapper.map(role, RoleModel.class);

            RoleModels.add(RoleModel);
        }
        return RoleModels;
    }

    public List<StateCodeModel> toListStateCodeModel(List<StateCode> stateCodesListEntity) {
        List<StateCodeModel> stateCodeModelList = new ArrayList<>();
        for(StateCode stateCodes: stateCodesListEntity)
        {
            StateCodeModel stateCodeModel = modelMapper.map(stateCodes, StateCodeModel.class);

            stateCodeModelList.add(stateCodeModel);
        }
        return stateCodeModelList;
    }

    public CandidateDTO toCandidateDTO(Candidate candidatesEntity) {
        CandidateDTO candidateDTO = modelMapper.map(candidatesEntity, CandidateDTO.class);
        return candidateDTO;
    }


}
