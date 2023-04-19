package com.ebitware.ehub.shared.port.filters;

public class Endpoint {
    String pattern;
    String method;

    public Endpoint(String pattern, String method) {
        this.pattern = pattern;
        this.method = method;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
