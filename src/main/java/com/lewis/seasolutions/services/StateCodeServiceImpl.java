package com.lewis.seasolutions.services;

import com.lewis.seasolutions.domain.entities.StateCode;
import com.lewis.seasolutions.repositories.StateCodeRepository;
import com.lewis.seasolutions.services.contracts.StateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class StateCodeServiceImpl implements StateCodeService {

    @Autowired
    private StateCodeRepository stateCodeRepository;

    @Override
    @Transactional
    public List<StateCode> findAll() {
        return stateCodeRepository.findAll();
    }

    @Override
    @Transactional
    public StateCode findById(Long id) {
        Optional<StateCode> stateCode =  stateCodeRepository.findById(id);
        if (stateCode.isEmpty())
        {
            throw new NullPointerException();
        }
        return stateCode.get();
    }
}
