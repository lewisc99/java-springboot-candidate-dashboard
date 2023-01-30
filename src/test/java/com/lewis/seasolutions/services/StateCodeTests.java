package com.lewis.seasolutions.services;


import com.lewis.seasolutions.SeaSolutionsApplication;
import com.lewis.seasolutions.config.MockBeansConfiguration;
import com.lewis.seasolutions.domain.entities.StateCode;
import com.lewis.seasolutions.repositories.StateCodeRepository;
import com.lewis.seasolutions.services.contracts.StateCodeService;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SeaSolutionsApplication.class}, properties = {"spring.jpa.defer-datasource-initialization=false",
        "spring.profiles.active=test"})
@Import(MockBeansConfiguration.class)
public class StateCodeTests {

    @Autowired
    private StateCode stateCode;

    @Autowired
    private StateCode stateCodeTwo;

    @MockBean
    private StateCodeRepository stateCodeRepository;

    @Autowired
    private StateCodeService stateCodeService;

    public List<StateCode> stateCodes = new ArrayList<>();

    @BeforeEach
    public void beforeEach()
    {
        stateCode.setId(1L);
        stateCode.setInitials("MG");
        stateCodeTwo.setId(2L);
        stateCodeTwo.setInitials("SP");

        stateCodes.addAll(Arrays.asList(stateCode,stateCodeTwo));
    }

    @Test
    @DisplayName("getAll return List StateCodes")
    public void getAllStateCodes()
    {
        when(stateCodeRepository.findAll()).thenReturn(stateCodes);
        List<StateCode> stateCodeList = stateCodeService.findAll();
        assertNotNull(stateCodeList);
        assertEquals(2, stateCodeList.size() );
    }

    @Test
    @DisplayName("getAll throw Runtime Exception")
    public void getAllReturnException()
    {
        when(stateCodeRepository.findAll()).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> {stateCodeService.findAll();});
    }

    @Test
    @DisplayName("findById return StateCode")
    public void findByIdReturnStateCode()
    {
        Long id = 1L;
        Optional<StateCode> StateCodeOptional = Optional.of(stateCode);
        when(stateCodeRepository.findById(id)).thenReturn(StateCodeOptional);
        StateCode stateCodeEntity = stateCodeService.findById(id);
        assertNotNull(stateCodeEntity);
        assertEquals(stateCode.getId(), stateCodeEntity.getId());
        assertEquals(stateCode.getInitials(), stateCodeEntity.getInitials());

    }

    @Test
    @DisplayName("findById throw NullPointException")
    public void findByIdThrowNullPointException()
    {
        Long id = 1L;
        when(stateCodeRepository.findById(id)).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> {stateCodeService.findById(1L);});
    }

}
