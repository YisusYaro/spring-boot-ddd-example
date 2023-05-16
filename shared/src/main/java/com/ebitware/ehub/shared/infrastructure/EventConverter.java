package com.ebitware.ehub.shared.infrastructure;

import com.ebitware.ehub.shared.domain.exceptions.AppException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class EventConverter implements MessageConverter {
    private final ObjectMapper objectMapper;

    public EventConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) {
        try {
            String json = objectMapper.writeValueAsString(object);
            return new Message(json.getBytes(), messageProperties);
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    @Override
    public Object fromMessage(Message message) {
        try {
            String json = new String(message.getBody());
            return objectMapper.readValue(json, Object.class);
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
}
