package com.ebitware.ehub.shared.port.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizationContext {
    private FilterChain chain;
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private BufferedRequestWrapper bufferedRequest;
    private BufferedResponseWrapper bufferedResponse;

    public AuthorizationContext(FilterChain chain, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, BufferedRequestWrapper bufferedRequest,
            BufferedResponseWrapper bufferedResponse) {
        this.chain = chain;
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.bufferedRequest = bufferedRequest;
        this.bufferedResponse = bufferedResponse;
    }

    public FilterChain getChain() {
        return chain;
    }

    public void setChain(FilterChain chain) {
        this.chain = chain;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public BufferedRequestWrapper getBufferedRequest() {
        return bufferedRequest;
    }

    public void setBufferedRequest(BufferedRequestWrapper bufferedRequest) {
        this.bufferedRequest = bufferedRequest;
    }

    public BufferedResponseWrapper getBufferedResponse() {
        return bufferedResponse;
    }

    public void setBufferedResponse(BufferedResponseWrapper bufferedResponse) {
        this.bufferedResponse = bufferedResponse;
    }

}
