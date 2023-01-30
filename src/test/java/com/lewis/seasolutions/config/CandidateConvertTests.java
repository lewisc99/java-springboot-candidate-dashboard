package com.lewis.seasolutions.config;

import com.lewis.seasolutions.SeaSolutionsApplication;
import com.lewis.seasolutions.domain.dtos.CandidateDTO;
import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.domain.entities.Role;
import com.lewis.seasolutions.domain.entities.StateCode;
import com.lewis.seasolutions.repositories.CandidateRepository;
import com.lewis.seasolutions.services.contracts.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {SeaSolutionsApplication.class}, properties = {"spring.jpa.defer-datasource-initialization=false",
        "spring.profiles.active=test"})
@Import(MockBeansConfiguration.class)
public class CandidateConvertTests {

    @Autowired
    private Candidate candidate;

    @Autowired
    private Candidate candidateTwo;

    @Autowired
    private Role role;

    @Autowired
    private Role roleTwo;

    @Autowired
    private StateCode stateCode;

    @Autowired
    private StateCode stateCodeTwo;

    @Autowired
    private CandidateConvert candidateConvert;

    public List<Candidate> candidates = new ArrayList<>();


    @BeforeEach
    public void beforeEach()
    {
        role.setId(1L);
        role.setName("Backend Developer Java Jr");
        roleTwo.setId(2L);
        roleTwo.setName("Backend Developer C#");

        stateCode.setId(1L);
        stateCode.setInitials("Backend Developer Java Jr");
        stateCode.setId(2L);
        stateCode.setInitials("Backend Developer C#");

        candidate.setId(1L);
        candidate.setUsername("Michele");
        candidate.setDoc("9833839938393");
        candidate.setEmail("michele@gmail.com");
        candidate.setPortfolio("https://portfolioexample.com.br");
        candidate.setRole(role);
        candidate.setStateCode(stateCode);

        candidateTwo.setId(2L);
        candidateTwo.setUsername("Nelson Gustavo");
        candidateTwo.setDoc("29393339393");
        candidateTwo.setEmail("nelson.golcalvez@gmail.com");
        candidateTwo.setPortfolio("https://portfolioexample.com.br");
        candidateTwo.setRole(roleTwo);
        candidateTwo.setStateCode(stateCodeTwo);

        candidates.addAll(Arrays.asList(candidate,candidateTwo));
    }


    @Test
    @DisplayName("convert Candidate Entity to CandidateDTO")
    public void convertToListCandidateDTO()
    {
        List<CandidateDTO> candidateDTOList = candidateConvert.toListCandidateDTO(candidates);
        assertNotNull(candidateDTOList);
        assertTrue(Objects.equals(candidateDTOList.get(0).getEmail(), "michele@gmail.com"));
        assertEquals(2,candidateDTOList.size());
    }

    @Test
    @DisplayName("convert Candidate EntitytoCandidateDTO ThrowError ClassCastException")
    public void convertToListCandidateDTOThrowErrorClassCastException()
    {
         assertThrows(ClassCastException.class, () -> {candidateConvert.toListCandidateDTO((List<Candidate>) candidate);});
    }
}
