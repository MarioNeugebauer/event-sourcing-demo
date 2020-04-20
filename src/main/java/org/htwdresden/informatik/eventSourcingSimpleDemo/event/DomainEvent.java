package org.htwdresden.informatik.eventSourcingSimpleDemo.event;

import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public abstract class DomainEvent {

    private static final Logger log = LoggerFactory.getLogger(DomainEvent.class);

    LocalDate recordedDate, occuredDate;

    public DomainEvent(LocalDate occuredDate) {
        log.info("created at "+occuredDate.toString());
        this.occuredDate = occuredDate;
        this.recordedDate = LocalDate.now();
    }

    public abstract void process();

}
