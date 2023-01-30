package com.lewis.seasolutions.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lewis.seasolutions.SeaSolutionsApplication;
import com.lewis.seasolutions.config.CandidateConvert;
import com.lewis.seasolutions.config.MockBeansConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestPropertySource("/application-test.properties")
@SpringBootTest(classes = {SeaSolutionsApplication.class}, properties = {"spring.jpa.defer-datasource-initialization=false",
        "spring.profiles.active=test"})
@Profile("test")
@Sql(scripts = {"classpath:create-data-test.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"classpath:delete-data-test.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Import(value = {MockBeansConfiguration.class})
@AutoConfigureMockMvc
public class CandidateControllerTests {

    @Autowired
    private CandidateConvert userConvert;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("getAll Return CandidateListDTO")
    public void getAllReturnCandidateListDTO() throws Exception
    {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk()).andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        ModelAndViewAssert.assertViewName(modelAndView, "candidate/candidate-list");
    }

    @Test
    @DisplayName("getById return Candidate")
    public void getByIdReturnCandidateDto() throws Exception
    {
        Long id = 1L;
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/candidate/{id}",id))
                .andExpect(status().isOk()).andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        ModelAndViewAssert.assertViewName(modelAndView, "candidate/candidate-by-id");
    }

    @Test
    @DisplayName("getById return ErrorNotFoundPage")
    public void getByIdReturnErrorNotFoundPage() throws Exception
    {
        Long id = 10L;
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/candidate/{id}",id))
                .andExpect(status().isOk()).andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        ModelAndViewAssert.assertViewName(modelAndView, "candidate/error-not-found");
    }

    @Test
    @DisplayName("delete remove Candidate")
    public void DeleteRemoveCandidate() throws Exception
    {
        Long id = 1L;
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/candidate/{id}/delete",id))
                .andExpect(status().is3xxRedirection()).andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        ModelAndViewAssert.assertViewName(modelAndView, "redirect:/");
    }

}
