package com.ebitware.ehub.shared.port;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {
    private Object data;
    private String operationId;
}
