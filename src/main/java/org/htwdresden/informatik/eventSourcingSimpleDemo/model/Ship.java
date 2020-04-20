package org.htwdresden.informatik.eventSourcingSimpleDemo.model;

import org.htwdresden.informatik.eventSourcingSimpleDemo.event.ArrivalEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DepartureEvent;

public class Ship {

    private Port port;
    private String name;

    public Ship(String name) {
        this.name = name;
    }

    public void handleArrival(ArrivalEvent arrivalEvent) {
        this.port = arrivalEvent.getPort();
    }

    public void handleDeparture(DepartureEvent departureEvent) {
        port = Port.AT_SEA;
    }

    public Port getPort() {
        return port;
    }

    public Ship setPort(Port port) {
        this.port = port;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }
}
