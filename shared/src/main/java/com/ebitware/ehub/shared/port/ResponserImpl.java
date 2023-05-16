package com.ebitware.ehub.shared.port;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ebitware.ehub.shared.application.Result;
import com.ebitware.ehub.shared.domain.exceptions.AppException;

@Component
public class ResponserImpl implements Responser {

    @Override
    public ResponseEntity<Object> handleCommand(String operationId, CommandExecuter executer) {
        try {
            Optional<Result> result = executer.execute();
            if (result.isPresent()) {
                Response response = Response
                        .builder()
                        .data(result.get())
                        .operationId(operationId)
                        .build();

                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }

            NoContentResponse response = NoContentResponse
                    .builder()
                    .operationId(operationId)
                    .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AppException appException) {
            appException.printStackTrace();

            ExceptionResponse response = ExceptionResponse
                    .builder()
                    .message(appException.getMessage())
                    .traceId(operationId)
                    .build();

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception exception) {
            exception.printStackTrace();

            ExceptionResponse response = ExceptionResponse
                    .builder()
                    .message("Internal server error")
                    .traceId(operationId)
                    .build();

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> handleQuery(String operationId, QueryExecuter executer) {
        try {
            Object result = executer.execute();

            Response response = Response
                    .builder()
                    .data(result)
                    .operationId(operationId)
                    .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AppException appException) {
            appException.printStackTrace();

            ExceptionResponse response = ExceptionResponse
                    .builder()
                    .message(appException.getMessage())
                    .traceId(operationId)
                    .build();

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } catch (Exception exception) {
            exception.printStackTrace();

            ExceptionResponse response = ExceptionResponse
                    .builder()
                    .message("Internal server error")
                    .traceId(operationId)
                    .build();

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void handleSaga(String operationId, SagaExecuter executer) {
        try {
            executer.execute();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
