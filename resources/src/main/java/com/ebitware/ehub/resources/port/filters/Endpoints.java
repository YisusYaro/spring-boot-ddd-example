package com.ebitware.ehub.resources.port.filters;

import org.springframework.http.HttpMethod;

import com.ebitware.ehub.shared.port.filters.Endpoint;

public class Endpoints {
    public static final Endpoint HANDLE_HUBSPOT_CALLBACK() {
        return new Endpoint("/resources", HttpMethod.POST.name());
    }
}
