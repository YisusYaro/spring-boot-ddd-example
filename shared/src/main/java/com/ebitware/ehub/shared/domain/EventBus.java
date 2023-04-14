package com.ebitware.ehub.shared.domain;

import com.ebitware.ehub.shared.domain.events.Event;

public interface EventBus {
    public void publish(Event event);
  }
  
