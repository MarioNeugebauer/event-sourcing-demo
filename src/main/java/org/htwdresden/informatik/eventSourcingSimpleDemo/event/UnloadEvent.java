package org.htwdresden.informatik.eventSourcingSimpleDemo.event;

import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Cargo;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class UnloadEvent extends DomainEvent {

    private static final Logger log = LoggerFactory.getLogger(UnloadEvent.class);

    private Ship ship;
    private Cargo cargo;

    public UnloadEvent(LocalDate date, Cargo cargo, Ship ship) {
        super(date);
        this.cargo = cargo;
        this.ship = ship;
    }

    @Override
    public void process() {
        log.info("process");
        ship.handleUnload(this);
    }

    public Cargo getCargo() {
        return cargo;
    }
}
