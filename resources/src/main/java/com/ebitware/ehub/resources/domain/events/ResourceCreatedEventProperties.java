package com.ebitware.ehub.resources.domain.events;

public class ResourceCreatedEventProperties {
    private String id;

    public ResourceCreatedEventProperties(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
