package com.ebitware.ehub.shared.infrastructure;

import org.springframework.stereotype.Component;

import com.ebitware.ehub.shared.domain.EHubLogger;

@Component
public class EHubLoggerImpl implements EHubLogger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
    
}
