package com.lewis.seasolutions.services;

import com.lewis.seasolutions.SeaSolutionsApplication;
import com.lewis.seasolutions.config.MockBeansConfiguration;
import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.domain.entities.Role;
import com.lewis.seasolutions.domain.entities.StateCode;
import com.lewis.seasolutions.repositories.CandidateRepository;
import com.lewis.seasolutions.services.contracts.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {SeaSolutionsApplication.class}, properties = {"spring.jpa.defer-datasource-initialization=false",
        "spring.profiles.active=test"})
@Import(MockBeansConfiguration.class)
public class CandidateServiceTests {

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

    @MockBean
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateService candidateService;

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
    @DisplayName("create Candidate")
    public void createCandidate()
    {
        when(candidateRepository.save(candidate)).thenReturn(candidate);
        candidateService.create(candidate);
        verify(candidateRepository, times(1)).save(candidate);
    }

    @Test
    @DisplayName("getAll return List Candidates")
    public void getAllCandidates()
    {
        when(candidateRepository.findAll()).thenReturn(candidates);
        List<Candidate> candidatesList = candidateService.findAll();
        assertNotNull(candidatesList);
        assertEquals(2, candidatesList.size() );
    }

    @Test
    @DisplayName("getAll throw Runtime Exception")
    public void getAllReturnException()
    {
        when(candidateRepository.findAll()).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> {candidateService.findAll();});
    }

    @Test
    @DisplayName("findById return Candidate")
    public void findByIdReturnCandidate()
    {
        Long id = 1L;
        Optional<Candidate> candidateOptional = Optional.of(candidate);
        when(candidateRepository.findById(id)).thenReturn(candidateOptional);
        Candidate candidateEntity = candidateService.findById(id);
        assertNotNull(candidateEntity);
        assertEquals(candidate.getEmail(),  candidateEntity.getEmail());
        assertEquals(candidate.getId(),  candidateEntity.getId());
        assertEquals(candidate.getDoc(),  candidateEntity.getDoc());
        assertEquals(candidate.getPortfolio(), candidate.getPortfolio());
        assertEquals(candidate.getStateCode(), candidate.getStateCode());
    }

    @Test
    @DisplayName("findById throw NullPointException")
    public void findByIdThrowNullPointException()
    {
        Long id = 1L;
        when(candidateRepository.findById(id)).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> {candidateService.findById(1L);});
    }

    @Test
    @DisplayName("delete Candidate")
    public void DeleteCandidate()
    {
        Long id = 1L;
        Mockito.doNothing().when(candidateRepository).deleteById(id);
        candidateService.delete(id);
        verify(candidateRepository,times(1)).deleteById(id);
    }

    @Test
    @DisplayName("delete Candidate throw error")
    public void DeleteCandidateThrowError()
    {
        Long id = 1L;
        Mockito.doThrow(NullPointerException.class).when(candidateRepository).deleteById(id);
        assertThrows(NullPointerException.class, () -> {candidateService.delete(id);});
    }

}
