package com.ebitware.ehub.shared.port;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionResponse {
    private String message;
    private String traceId;
}
