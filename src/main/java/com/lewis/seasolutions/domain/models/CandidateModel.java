package com.lewis.seasolutions.domain.models;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateModel {
    private Long id;

    @NotNull(message="Is required")
    @NotBlank(message = "cannot be empty")
    @Size(min=1,max=10,message="Username Size must be at least 1")
    @Pattern(regexp = "[a-zA-Z]+")
    private String username;

    @NotNull(message="Is required")
    @Size(min=10,max=20,message="size must be at least 10 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email is invalid")
    @NotBlank(message = "cannot be empty")
    private String email;

    @Size(min = 5, max = 20, message = "Doc size must be at least 5 characters")
    @NotNull(message="Is required")
    @Pattern(regexp = "^[0-9]*$", message = "Cannot contain letters")
    @NotBlank(message = "cannot be empty")
    private String doc;
    private Long roleId;

    @NotNull(message="Is required")
    private List<RoleModel> roles = new ArrayList<>();

    @NotNull(message="Is required")
    @Pattern(regexp = "^(ftp|http|https):\\/\\/[^ \"]+$", message = "Portfolio format is invalid")
    @NotBlank(message = "cannot be empty")
    private String portfolio;

    private Long stateCodeId;

    @NotNull(message="Is required")
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
