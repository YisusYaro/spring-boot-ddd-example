package com.ebitware.ehub.resources.domain;

import com.ebitware.ehub.resources.domain.values.ResourceId;

public interface ResourceFactory {
    public Resource create(ResourceId id);

    public Resource reconstitute(ResourceId id);
}
