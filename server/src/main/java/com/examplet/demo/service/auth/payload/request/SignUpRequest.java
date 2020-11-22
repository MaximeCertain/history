package com.examplet.demo.service.auth.payload.request;

import com.examplet.demo.beans.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SignUpRequest {
    private String username;
    private String password;
    private String email;
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
