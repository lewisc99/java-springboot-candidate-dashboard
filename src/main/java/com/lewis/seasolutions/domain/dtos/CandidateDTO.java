package com.lewis.seasolutions.domain.dtos;

public class CandidateDTO {
    private Long id;
    private String username;
    private String email;
    private String doc;
    private RoleDTO role;
    private String portfolio;
    private StateCodeDTO stateCode;

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

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public StateCodeDTO getStateCode() {
        return stateCode;
    }

    public void setStateCode(StateCodeDTO stateCode) {
        this.stateCode = stateCode;
    }
}
