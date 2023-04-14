package com.ebitware.ehub.resources.domain;

import com.ebitware.ehub.resources.domain.primitives.ResourceProperties;
import com.ebitware.ehub.shared.domain.EventBus;

public interface Resource {
    public ResourceProperties getProperties();
   
    public void executeBusinessLogic();

    public void commit(EventBus eventBus);
}
