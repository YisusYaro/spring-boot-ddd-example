package com.ebitware.ehub.shared.application.queries;

import com.ebitware.ehub.shared.application.Result;

public interface QueryHandler<Q extends Query, R extends Result> {
    R handle(Q query);
}
