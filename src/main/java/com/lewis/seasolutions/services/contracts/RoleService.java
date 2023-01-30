package com.lewis.seasolutions.services.contracts;

import com.lewis.seasolutions.domain.entities.Role;
import java.util.List;

public interface RoleService {

    List<Role> findAll();
    Role findById(Long id);
}
