package com.ebitware.ehub.resources.port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebitware.ehub.resources.application.commands.CreateResourceCommand;
import com.ebitware.ehub.resources.application.commands.CreateResourceHandler;
import com.ebitware.ehub.resources.port.requests.CreateResourceRequestBody;
import com.ebitware.ehub.shared.domain.EHubLogger;
import com.ebitware.ehub.shared.domain.IdGenerator;
import com.ebitware.ehub.shared.port.Responser;

@RestController
@RequestMapping("/resources")
public class ResourcesController {
    @Autowired
    private EHubLogger eHubLogger;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private Responser responser;
    @Autowired
    private CreateResourceHandler createResourceHandler;

    @PostMapping
    public ResponseEntity<Object> createResource(@RequestBody CreateResourceRequestBody body) {
        String operationId = this.idGenerator.get();
        return this.responser.handleCommand(operationId, () -> {
            this.eHubLogger.log("Create resource operation id: " + operationId);
            CreateResourceCommand command = new CreateResourceCommand(operationId, body.getId());
            return this.createResourceHandler.handle(command);
        });
    }

}
