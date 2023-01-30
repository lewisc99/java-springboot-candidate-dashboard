package com.lewis.seasolutions.config;

import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.domain.entities.Role;
import com.lewis.seasolutions.domain.entities.StateCode;
import com.lewis.seasolutions.domain.models.CandidateModel;
import com.lewis.seasolutions.domain.models.RoleModel;
import com.lewis.seasolutions.domain.models.StateCodeModel;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@TestConfiguration
@ComponentScan(basePackages = {"com.lewis.seasolutions"})
public class MockBeansConfiguration {

    @Bean
    @Scope(value = "prototype")
    public Candidate getCandidate()
    {
        return new Candidate();
    }


    @Bean
    @Scope(value="prototype")
    public Role getRole()
    {
        return new Role();
    }
    @Bean
    @Scope(value="prototype")
    public StateCode getStateCode()
    {
        return new StateCode();
    }

    @Bean
    @Scope(value = "prototype")
    public CandidateModel getCandidateModel()
    {
        return new CandidateModel();
    }

    @Bean
    @Scope(value="prototype")
    public RoleModel getRoleModel()
    {
        return new RoleModel();
    }

    @Bean
    @Scope(value="prototype")
    public StateCodeModel getStateCodeModel()
    {
        return new StateCodeModel();
    }




}
