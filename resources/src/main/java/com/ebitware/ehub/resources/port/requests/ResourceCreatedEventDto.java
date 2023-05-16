package com.ebitware.ehub.resources.port.requests;

import com.ebitware.ehub.shared.port.request.EventDto;

public class ResourceCreatedEventDto extends EventDto{
    private ResourceCreatedEventPropertiesDto properties;

    public ResourceCreatedEventPropertiesDto getProperties() {
        return properties;
    }

    public void setProperties(ResourceCreatedEventPropertiesDto properties) {
        this.properties = properties;
    }

}
