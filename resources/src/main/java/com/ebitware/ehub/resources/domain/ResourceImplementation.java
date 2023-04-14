package com.ebitware.ehub.resources.domain;

import com.ebitware.ehub.resources.domain.primitives.ResourceProperties;
import com.ebitware.ehub.resources.domain.values.ResourceId;
import com.ebitware.ehub.shared.domain.AggregateRoot;

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

    public void executeBusinessLogic() {
        // record new events if is necessary
        // modify internal properties if is necessary
        System.out.println("🧠 executing business logic...");
    }

}
