package com.application.zuulproxy.model;


import java.io.Serializable;

public class Users implements Serializable {
    private static final long serialVersionUID = 7464724748653168973L;

    private String name;
    private String code;
    private String role;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

