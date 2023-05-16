package com.ebitware.ehub.shared.port;

import org.springframework.http.ResponseEntity;

public interface Responser {
    public ResponseEntity<Object> handleCommand(String operationId, CommandExecuter executer);

    public ResponseEntity<Object> handleQuery(String operationId, QueryExecuter executer);

    public void handleSaga(String operationId, SagaExecuter executer);
 
}
