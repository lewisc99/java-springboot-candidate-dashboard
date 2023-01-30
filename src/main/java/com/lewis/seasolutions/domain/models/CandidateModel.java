package com.lewis.seasolutions.domain.models;

import java.util.ArrayList;
import java.util.List;

public class CandidateModel {
    private Long id;
    private String username;
    private String email;
    private String doc;
    private Long roleId;
    private List<RoleModel> roles = new ArrayList<>();
    private String portfolio;

    private Long stateCodeId;
    private List<StateCodeModel> stateCodes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public Long getStateCodeId() {
        return stateCodeId;
    }

    public void setStateCodeId(Long stateCodeId) {
        this.stateCodeId = stateCodeId;
    }

    public List<StateCodeModel> getStateCodes() {
        return stateCodes;
    }

    public void setStateCodes(List<StateCodeModel> stateCodes) {
        this.stateCodes = stateCodes;
    }
}
