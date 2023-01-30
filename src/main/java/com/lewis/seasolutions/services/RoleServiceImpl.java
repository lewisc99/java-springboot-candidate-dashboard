package com.lewis.seasolutions.services;

import com.lewis.seasolutions.domain.entities.Role;
import com.lewis.seasolutions.repositories.RoleRepository;
import com.lewis.seasolutions.services.contracts.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public List<Role> findAll() {
         return roleRepository.findAll();
    }
}
