package com.lewis.seasolutions.services;

import com.lewis.seasolutions.SeaSolutionsApplication;
import com.lewis.seasolutions.config.MockBeansConfiguration;
import com.lewis.seasolutions.domain.entities.Candidate;
import com.lewis.seasolutions.domain.entities.Role;
import com.lewis.seasolutions.repositories.RoleRepository;
import com.lewis.seasolutions.services.contracts.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SeaSolutionsApplication.class}, properties = {"spring.jpa.defer-datasource-initialization=false",
        "spring.profiles.active=test"})
@Import(MockBeansConfiguration.class)
public class RoleServiceTests {

    @Autowired
    private Role role;

    @Autowired
    private Role roleTwo;

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    public List<Role> roles = new ArrayList<>();

    @BeforeEach
    public void beforeEach()
    {
        role.setId(1L);
        role.setName("Backend Developer Java Jr");
        roleTwo.setId(2L);
        roleTwo.setName("Backend Developer C#");

        roles.addAll(Arrays.asList(role,roleTwo));
    }

    @Test
    @DisplayName("getAll return List Roles")
    public void getAllRoles()
    {
        when(roleRepository.findAll()).thenReturn(roles);
        List<Role> roleList = roleService.findAll();
        assertNotNull(roleList);
        assertEquals(2, roleList.size() );
    }

    @Test
    @DisplayName("getAll throw Runtime Exception")
    public void getAllReturnException()
    {
        when(roleRepository.findAll()).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> {roleService.findAll();});
    }

    @Test
    @DisplayName("findById return Role")
    public void findByIdReturnRole()
    {
        Long id = 1L;
        Optional<Role> roleOptional = Optional.of(role);
        when(roleRepository.findById(id)).thenReturn(roleOptional);
        Role roleEntity = roleService.findById(id);
        assertNotNull(roleEntity);
        assertEquals(role.getId(), roleEntity.getId());
        assertEquals(role.getName(),  roleEntity.getName());

    }

    @Test
    @DisplayName("findById throw NullPointException")
    public void findByIdThrowNullPointException()
    {
        Long id = 1L;
        when(roleRepository.findById(id)).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> {roleService.findById(1L);});
    }

}
