package com.lewis.seasolutions.services.contracts;

import com.lewis.seasolutions.domain.entities.Candidate;

import java.util.List;

public interface CandidateService {

    void create(Candidate candidate);
    List<Candidate> findAll();
    Candidate findById(Long id);
    void delete(Long id);
}
