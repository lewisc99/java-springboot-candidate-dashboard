package com.lewis.seasolutions.services;


import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.repositories.CandidateRepository;
import com.lewis.seasolutions.services.contracts.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository repository;
    @Override
    @Transactional
    public List<Candidate> findAll() {
        return  repository.findAll();
    }
}
