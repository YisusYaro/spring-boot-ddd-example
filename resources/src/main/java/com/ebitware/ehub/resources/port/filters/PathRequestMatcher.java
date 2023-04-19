package com.ebitware.ehub.resources.port.filters;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import com.ebitware.ehub.shared.port.filters.Endpoint;

@Component
public class PathRequestMatcher {
    public Boolean matches(Endpoint endpoint, HttpServletRequest httpServletRequest) {
        RequestMatcher uriMatcher = new AntPathRequestMatcher(endpoint.getPattern(), endpoint.getMethod());
        return uriMatcher.matches(httpServletRequest);
    }
}
