package com.ebitware.ehub.shared.port;

import java.util.Optional;

import com.ebitware.ehub.shared.application.Result;

public interface CommandExecuter {
    Optional<Result> execute();
}

