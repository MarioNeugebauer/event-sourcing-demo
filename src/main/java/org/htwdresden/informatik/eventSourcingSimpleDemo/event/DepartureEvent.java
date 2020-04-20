package org.htwdresden.informatik.eventSourcingSimpleDemo.event;

import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Port;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class DepartureEvent extends DomainEvent {

    private static final Logger log = LoggerFactory.getLogger(DepartureEvent.class);

    private Port port;
    private Ship ship;

    public DepartureEvent(LocalDate date, Port port, Ship ship) {
        super(date);
        this.port = port;
        this.ship = ship;
    }

    @Override
    public void process() {
        log.info("process");
        ship.handleDeparture(this);
    }

    public Port getPort() {
        return port;
    }

    public DepartureEvent setPort(Port port) {
        this.port = port;
        return this;
    }

    public Ship getShip() {
        return ship;
    }

    public DepartureEvent setShip(Ship ship) {
        this.ship = ship;
        return this;
    }
}
