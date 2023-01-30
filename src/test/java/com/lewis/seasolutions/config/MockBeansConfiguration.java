package com.lewis.seasolutions.config;

import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.domain.entities.Role;
import com.lewis.seasolutions.domain.entities.StateCode;
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


}
