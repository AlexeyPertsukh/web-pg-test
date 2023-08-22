package com.example.webpgtest.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    DEMO,
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
