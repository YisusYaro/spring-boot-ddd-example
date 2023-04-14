package com.ebitware.ehub.shared.infrastructure;

import org.springframework.stereotype.Component;

import com.ebitware.ehub.shared.domain.IdGenerator;
import com.github.f4b6a3.ulid.UlidCreator;

@Component
public class IdGeneratorImpl implements IdGenerator {
    public String get() {
        return UlidCreator.getUlid().toString();
    }
}

