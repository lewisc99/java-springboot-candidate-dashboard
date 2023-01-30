package com.lewis.seasolutions.config;

import com.lewis.seasolutions.SeaSolutionsApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(classes = {SeaSolutionsApplication.class}, properties = {"spring.jpa.defer-datasource-initialization=false",
        "spring.profiles.active=test"})
@Import(MockBeansConfiguration.class)
public class CandidateConvertTests {
    
}
