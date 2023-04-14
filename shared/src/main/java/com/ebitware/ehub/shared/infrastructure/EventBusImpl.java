package com.ebitware.ehub.shared.infrastructure;

import org.springframework.stereotype.Component;

import com.ebitware.ehub.shared.domain.EventBus;
import com.ebitware.ehub.shared.domain.events.Event;

@Component
public class EventBusImpl implements EventBus {

    @Override
    public void publish(Event event) {
        System.out.println("📡 event emitted: " + event);
    }

}
