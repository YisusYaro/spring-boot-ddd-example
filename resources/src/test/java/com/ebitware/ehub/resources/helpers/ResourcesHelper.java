package com.ebitware.ehub.resources.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebitware.ehub.resources.domain.Resource;
import com.ebitware.ehub.resources.domain.ResourceFactory;
import com.ebitware.ehub.resources.domain.values.ResourceId;

@Component
public class ResourcesHelper {
    @Autowired
    private ResourceFactory resourceFactory;

    public Resource getUser() {
        return this.resourceFactory.create(new ResourceId("01GYAM5DBSD21NP1S5ENT7V3V5"));
    }
}
