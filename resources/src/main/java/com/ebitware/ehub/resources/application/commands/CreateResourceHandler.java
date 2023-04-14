package com.ebitware.ehub.resources.application.commands;

import java.util.Optional;

import com.ebitware.ehub.shared.application.Result;
import com.ebitware.ehub.shared.application.commands.CommandHandler;

public interface CreateResourceHandler
        extends CommandHandler<CreateResourceCommand, Result> {
    public Optional<Result> handle(CreateResourceCommand command);
}
