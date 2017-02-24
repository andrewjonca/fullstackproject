package com.fullstack.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by akjonca on 2/24/17.
 */

public class Authority implements GrantedAuthority {

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
