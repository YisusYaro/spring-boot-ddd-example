package com.ebitware.ehub.shared.port.filters;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.ebitware.ehub.shared.domain.exceptions.AppException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationHandlerImpl implements AuthorizationHandler {

    @Override
    public void handleAuthorizationExceptions(
            AuthorizationContext context,
            String operationId,
            AuthorizationExecution authorizationExecution) throws IOException {
        FilterChain chain = context.getChain();
        HttpServletRequest httpServletRequest = context.getHttpServletRequest();
        HttpServletResponse httpServletResponse = context.getHttpServletResponse();
        BufferedRequestWrapper bufferedRequest = context.getBufferedRequest();
        BufferedResponseWrapper bufferedResponse = context.getBufferedResponse();

        try {
            authorizationExecution.execute();
            chain.doFilter(bufferedRequest, bufferedResponse);
        } catch (AppException exception) {
            String uri = httpServletRequest.getRequestURL() + "?" +
                    httpServletRequest.getQueryString();

            String body = bufferedRequest.getRequestBody();

            exception.printStackTrace();

            System.out.println("🔗 uri: " + uri);
            System.out.println("👨‍💻 body: " + body);

            httpServletResponse.getWriter()
                    .write("{ \"message\": \"" + exception.getMessage() + "\", \"code\": " + 400
                            + ", \"traceId\": \""
                            + operationId + "\"}");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setStatus(400);
        } catch (Exception exception) {
            String uri = httpServletRequest.getRequestURL() + "?" +
                    httpServletRequest.getQueryString();

            String body = bufferedRequest.getRequestBody();

            exception.printStackTrace();

            System.out.println("🔗 uri: " + uri);
            System.out.println("👨‍💻 body: " + body);

            httpServletResponse.getWriter()
                    .write("{ \"message\": \"Internal server error\", \"code\": 500, \"traceId\": \"" + operationId
                            + "\"}");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setStatus(500);
        }

    }
}
