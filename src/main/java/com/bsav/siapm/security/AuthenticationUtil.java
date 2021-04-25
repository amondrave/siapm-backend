package com.bsav.siapm.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component("authenticationUtil")
public class AuthenticationUtil {

    public String getDocument() {
        return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().
                getPrincipal()).getUsername();
    }
}

