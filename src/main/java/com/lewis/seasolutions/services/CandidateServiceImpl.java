package com.lewis.seasolutions.services;

import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.repositories.CandidateRepository;
import com.lewis.seasolutions.services.contracts.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository repository;

    @Override
    @Transactional
    public void create(Candidate candidate) {
        repository.save(candidate);
    }

    @Override
    @Transactional
    public List<Candidate> findAll() {
        return  repository.findAll();
    }

    @Override
    @Transactional
    public Candidate findById(Long id) {
       Optional<Candidate> candidate =  repository.findById(id);
       if(candidate.isEmpty())
       {
           throw new NullPointerException("Id not found: " + id);
       }
       return candidate.get();
    }

    @Override
    @Transactional
    public void delete(Long id) {
         repository.deleteById(id);
    }
}
