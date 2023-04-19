package com.ebitware.ehub.resources.port.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.ebitware.ehub.shared.domain.IdGenerator;
import com.ebitware.ehub.shared.port.filters.AuthorizationContext;
import com.ebitware.ehub.shared.port.filters.AuthorizationHandler;
import com.ebitware.ehub.shared.port.filters.BufferedRequestWrapper;
import com.ebitware.ehub.shared.port.filters.BufferedResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationFilters extends GenericFilterBean {
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private AuthorizationHandler authorizationHandler;
    @Autowired
    private PathRequestMatcher pathRequestMatcher;
    @Autowired
    private CreateResourceAuthorizer createResourceAuthorizer;

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(
                httpServletRequest);
        BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(
                httpServletResponse);

        AuthorizationContext authorizationContext = new AuthorizationContext(chain, httpServletRequest,
                httpServletResponse, bufferedRequest, bufferedResponse);

        String operationId = this.idGenerator.get();

        this.authorizationHandler.handleAuthorizationExceptions(
                authorizationContext,
                operationId, () -> {
                    if (this.pathRequestMatcher.matches(
                            Endpoints.HANDLE_HUBSPOT_CALLBACK(),
                            httpServletRequest)) {
                        this.createResourceAuthorizer.verify(authorizationContext);
                    }
                });

    }

}
