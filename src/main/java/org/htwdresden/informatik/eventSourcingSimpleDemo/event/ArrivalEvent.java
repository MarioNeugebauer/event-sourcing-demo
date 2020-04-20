package org.htwdresden.informatik.eventSourcingSimpleDemo.event;

import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Port;
import org.htwdresden.informatik.eventSourcingSimpleDemo.model.Ship;

import java.time.LocalDate;

public class ArrivalEvent extends DomainEvent {
    private Port port;
    private Ship ship;

    public ArrivalEvent(LocalDate date, Port port, Ship ship) {
        super(date);
        setPort(port);
        setShip(ship);
    }

    @Override
    public void process() {
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
