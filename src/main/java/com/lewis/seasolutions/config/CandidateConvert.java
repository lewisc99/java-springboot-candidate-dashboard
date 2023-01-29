package com.lewis.seasolutions.config;

import com.lewis.seasolutions.domain.dtos.CandidateDTO;
import com.lewis.seasolutions.domain.entities.Candidate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateConvert {

    @Autowired
    private ModelMapper modelMapper;

    public List<CandidateDTO> toCandidateDTO(List<Candidate> candidatesEntity) {
        List<CandidateDTO> candidatesDTOS = new ArrayList<>();
        for(Candidate candidate: candidatesEntity)
        {
            CandidateDTO userDTO = modelMapper.map(candidate, CandidateDTO.class);
            candidatesDTOS.add(userDTO);
        }
        return candidatesDTOS;
    }

}
