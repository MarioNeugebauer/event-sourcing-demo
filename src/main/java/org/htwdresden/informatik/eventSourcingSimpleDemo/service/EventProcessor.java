package org.htwdresden.informatik.eventSourcingSimpleDemo.service;

import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
    List logList = new ArrayList<DomainEvent>();

    public void process(DomainEvent domainEvent) {
        domainEvent.process();
        logList.add(domainEvent);
    }
}
