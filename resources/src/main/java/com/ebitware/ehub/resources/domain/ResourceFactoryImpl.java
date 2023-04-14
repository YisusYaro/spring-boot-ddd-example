package com.ebitware.ehub.resources.domain;

import org.springframework.stereotype.Component;

import com.ebitware.ehub.resources.domain.values.ResourceId;

@Component
public class ResourceFactoryImpl implements ResourceFactory {

    @Override
    public Resource create(ResourceId id) {
        ResourceImplementation resource = new ResourceImplementation();
        resource.setId(id);
        return resource;
    }

    @Override
    public Resource reconstitute(ResourceId id) {
        ResourceImplementation resource = new ResourceImplementation();
        resource.setId(id);
        return resource;
    }

}
