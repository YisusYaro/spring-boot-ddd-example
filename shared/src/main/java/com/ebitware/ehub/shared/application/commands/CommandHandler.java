package com.ebitware.ehub.shared.application.commands;

import java.util.Optional;

import com.ebitware.ehub.shared.application.Result;

public interface CommandHandler<C extends Command, R extends Result> {
    Optional<R> handle(C command);
}

