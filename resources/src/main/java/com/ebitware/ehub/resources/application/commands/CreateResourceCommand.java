package com.ebitware.ehub.resources.application.commands;

import com.ebitware.ehub.shared.application.commands.Command;

public class CreateResourceCommand extends Command {
    private String id;

    public CreateResourceCommand(String operationId, String id) {
        super(operationId);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
