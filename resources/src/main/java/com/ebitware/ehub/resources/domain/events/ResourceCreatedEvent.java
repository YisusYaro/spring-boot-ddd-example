package com.ebitware.ehub.resources.domain.events;

import com.ebitware.ehub.shared.domain.events.Event;

public class ResourceCreatedEvent extends Event {
    private static String EVENT_NAME = "resourceCreated";

    public ResourceCreatedEvent(String id) {
        super(id, ResourceCreatedEvent.EVENT_NAME,
                new ResourceCreatedEventProperties(id));
    }
}
