package com.lewis.seasolutions.services.contracts;

import com.lewis.seasolutions.domain.entities.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> findAll();
    Candidate findById(Long id);
}
