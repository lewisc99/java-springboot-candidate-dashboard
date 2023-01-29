package com.lewis.seasolutions.domain.models;

public class CandidateModel {
    private Long id;
    private String username;
    private String email;
    private String doc;
    private RoleModel role;
    private String portfolio;
    private StateCodeModel stateCode;

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

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public StateCodeModel getStateCode() {
        return stateCode;
    }

    public void setStateCode(StateCodeModel stateCode) {
        this.stateCode = stateCode;
    }
}
