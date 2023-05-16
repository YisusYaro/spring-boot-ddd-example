package com.ebitware.ehub.shared.infrastructure;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebitware.ehub.shared.domain.EventBus;
import com.ebitware.ehub.shared.domain.events.Event;

@Component
public class EventBusImpl implements EventBus {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void publish(Event event) {
        this.rabbitTemplate.convertAndSend(event.getEventName(), event); 
    }

}
