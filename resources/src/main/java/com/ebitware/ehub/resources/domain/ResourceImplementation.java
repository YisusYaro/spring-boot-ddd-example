package com.ebitware.ehub.resources.domain;

import com.ebitware.ehub.resources.domain.events.ResourceCreatedEvent;
import com.ebitware.ehub.resources.domain.primitives.ResourceProperties;
import com.ebitware.ehub.resources.domain.values.ResourceId;
import com.ebitware.ehub.shared.domain.AggregateRoot;
import com.ebitware.ehub.shared.domain.events.Event;

public class ResourceImplementation extends AggregateRoot implements Resource {
    private ResourceId id;

    public void setId(ResourceId id) {
        this.id = id;
    }

    public ResourceProperties getProperties() {
        return new ResourceProperties() {

            @Override
            public String getId() {
                return id.getValue();
            }

        };
    }

    @Override
    public void executeBusinessLogic() {
        // modify internal properties if is necessary

        // record new events if is necessary
        Event event = new ResourceCreatedEvent(this.id.getValue());
        this.record(event);

        System.out.println("🧠 executing business logic...");
    }

}
