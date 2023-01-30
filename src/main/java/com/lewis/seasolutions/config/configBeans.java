package com.lewis.seasolutions.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configBeans {

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
