package org.htwdresden.informatik.eventSourcingSimpleDemo.event;

import java.time.LocalDate;

public abstract class DomainEvent {

    LocalDate recordedDate, occuredDate;

    public DomainEvent(LocalDate occuredDate) {
        this.occuredDate = occuredDate;
        this.recordedDate = LocalDate.now();
    }

    public abstract void process();

}
