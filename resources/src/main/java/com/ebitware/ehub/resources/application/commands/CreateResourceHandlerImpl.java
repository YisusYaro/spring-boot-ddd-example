package com.ebitware.ehub.resources.application.commands;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebitware.ehub.resources.domain.Resource;
import com.ebitware.ehub.resources.domain.ResourceFactory;
import com.ebitware.ehub.resources.domain.ResourceRepository;
import com.ebitware.ehub.resources.domain.values.ResourceId;
import com.ebitware.ehub.shared.application.Result;
import com.ebitware.ehub.shared.domain.EventBus;

@Component
public class CreateResourceHandlerImpl implements CreateResourceHandler {
    @Autowired
    private ResourceFactory resourceFactory;
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private EventBus eventBus;

    @Override
    public Optional<Result> handle(CreateResourceCommand command) {
        Resource resource = this.resourceFactory.create(new ResourceId(command.getId()));

        resource.executeBusinessLogic();

        this.resourceRepository.save(resource);

        resource.commit(this.eventBus);

        return Optional.empty();
    }

}
