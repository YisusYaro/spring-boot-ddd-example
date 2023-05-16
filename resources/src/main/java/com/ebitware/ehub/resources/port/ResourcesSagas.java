package com.ebitware.ehub.resources.port;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebitware.ehub.resources.port.requests.ResourceCreatedEventDto;
import com.ebitware.ehub.shared.domain.EHubLogger;
import com.ebitware.ehub.shared.domain.IdGenerator;
import com.ebitware.ehub.shared.domain.exceptions.AppException;
import com.ebitware.ehub.shared.port.Responser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ResourcesSagas {
    @Autowired
    private EHubLogger eHubLogger;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private Responser responser;

    @RabbitListener(queues = { "resourceCreated" })
    public void handleResourceCreated(String payload) {
        String operationId = this.idGenerator.get();
        this.responser.handleSaga(operationId, () -> {
            this.eHubLogger.log("Handle resource created operation id: " + operationId);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                ResourceCreatedEventDto eventDto = objectMapper.readValue(payload, ResourceCreatedEventDto.class);
                this.eHubLogger.log("〽️ resource created id: " + eventDto.getProperties().getId());
                // Execute command as reactiveness to event
            } catch (IOException e) {
                throw new AppException(e.getMessage());
            }
        });
    }

}
