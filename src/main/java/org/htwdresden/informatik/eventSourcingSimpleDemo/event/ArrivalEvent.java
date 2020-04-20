package org.htwdresden.informatik.eventSourcingSimpleDemo.event;

import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Port;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ArrivalEvent extends DomainEvent {
    private static final Logger log = LoggerFactory.getLogger(ArrivalEvent.class);

    private Port port;
    private Ship ship;

    public ArrivalEvent(LocalDate date, Port port, Ship ship) {
        super(date);
        setPort(port);
        setShip(ship);
    }

    @Override
    public void process() {
        log.info("process");
        ship.handleArrival(this);
    }

    public Port getPort() {
        return port;
    }

    public ArrivalEvent setPort(Port port) {
        this.port = port;
        return this;
    }

    public Ship getShip() {
        return ship;
    }

    public ArrivalEvent setShip(Ship ship) {
        this.ship = ship;
        return this;
    }
}
