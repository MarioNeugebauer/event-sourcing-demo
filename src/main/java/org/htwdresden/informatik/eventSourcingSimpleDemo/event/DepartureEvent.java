package org.htwdresden.informatik.eventSourcingSimpleDemo.event;

import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Port;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;

import java.time.LocalDate;

public class DepartureEvent extends DomainEvent {

    private Port port;
    private Ship ship;

    public DepartureEvent(LocalDate date, Port port, Ship ship) {
        super(date);
        this.port = port;
        this.ship = ship;
    }

    @Override
    public void process() {
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
