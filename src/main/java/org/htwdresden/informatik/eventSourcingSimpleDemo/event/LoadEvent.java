package org.htwdresden.informatik.eventSourcingSimpleDemo.event;

import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Cargo;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class LoadEvent extends DomainEvent {

    private static final Logger log = LoggerFactory.getLogger(LoadEvent.class);

    private Ship ship;
    private Cargo cargo;

    public LoadEvent(LocalDate date, Cargo cargo, Ship ship) {
        super(date);
        log.info("created at "+date.toString()+" for ship "+ship.getName()+" with cargo "+cargo.getType());
        this.cargo = cargo;
        this.ship = ship;
    }

    @Override
    public void process() {
        log.info("process");
        ship.handleLoad(this);
    }

    public Ship getShip() {
        return ship;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
