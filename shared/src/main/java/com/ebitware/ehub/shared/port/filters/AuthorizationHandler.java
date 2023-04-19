package com.ebitware.ehub.shared.port.filters;

import java.io.IOException;

public interface AuthorizationHandler {
    public void handleAuthorizationExceptions(
            AuthorizationContext context,
            String operationId,
            AuthorizationExecution authorizationExecution) throws IOException;

}

