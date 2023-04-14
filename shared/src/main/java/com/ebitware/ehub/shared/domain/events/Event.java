package com.ebitware.ehub.shared.domain.events;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.github.f4b6a3.ulid.UlidCreator;

public abstract class Event {
  static String EVENT_NAME;
  private String aggregateId;
  private String eventId;
  private String occurredOn;
  private String eventName;
  private Object properties;

  public Event(String aggregateId, String eventName, Object properties) {
    this.aggregateId = aggregateId;
    this.eventId = UlidCreator.getUlid().toString();
    this.occurredOn = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
    this.eventName = eventName;
    this.properties = properties;
  }

  public String getAggregateId() {
    return this.aggregateId;
  }

  public String getEventId() {
    return this.eventId;
  }

  public String getOccurredOn() {
    return this.occurredOn;
  }

  public String getEventName() {
    return this.eventName;
  }

  public Object getProperties() {
    return properties;
  }
}
