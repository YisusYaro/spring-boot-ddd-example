package com.ebitware.ehub.resources.infrastructure;

import org.springframework.stereotype.Component;

import com.ebitware.ehub.resources.domain.Resource;
import com.ebitware.ehub.resources.domain.ResourceRepository;

@Component
public class ResourceRepositoryImpl implements ResourceRepository {

    @Override
    public void save(Resource resource) {
        System.out.println("💾 save resource: " + resource);
    }

}
