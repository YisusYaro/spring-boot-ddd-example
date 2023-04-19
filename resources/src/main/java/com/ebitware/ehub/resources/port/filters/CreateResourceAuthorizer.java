package com.ebitware.ehub.resources.port.filters;

import org.springframework.stereotype.Component;

import com.ebitware.ehub.shared.port.filters.AuthorizationContext;

@Component
public class CreateResourceAuthorizer {
    public void verify(AuthorizationContext context) {
        System.out.println("🔒 verifying authorization context...");
    }
}
