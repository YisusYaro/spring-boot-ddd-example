package com.ebitware.ehub.shared.port;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoContentResponse {
    private String operationId;
}
