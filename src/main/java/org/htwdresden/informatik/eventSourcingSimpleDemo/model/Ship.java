package org.htwdresden.informatik.eventSourcingSimpleDemo.model;

import org.htwdresden.informatik.eventSourcingSimpleDemo.event.ArrivalEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.DepartureEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.LoadEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.UnloadEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.service.EventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private static final Logger log = LoggerFactory.getLogger(Ship.class);

    private Port port;
    private String name;
    private List<Cargo> cargoList = new ArrayList<Cargo>();

    public Ship(String name) {
        this.name = name;
    }

    public void handleArrival(ArrivalEvent arrivalEvent) {
        log.info("handleArrival");
        this.port = arrivalEvent.getPort();
        cargoList.forEach(cargo -> cargo.handleArrival(arrivalEvent));
    }

    public void handleLoad(LoadEvent loadEvent) {
        log.info("handleLoad");
        // add only, if the cargo is not loaded already before --> very simple model
        loadEvent.getCargo().handleLoad(loadEvent);
        if( cargoList.stream()
                .filter(cargo -> cargo.getType().equals(loadEvent.getCargo().getType()))
                .count() == 0) {
            cargoList.add(loadEvent.getCargo());
        }
    }

    public void handleUnload(UnloadEvent unloadEvent) {
        log.info("handleUnload");
        // simple removement of cargo --> remove all, without regards to amount
        cargoList.removeIf(cargo -> cargo.getType().equals(unloadEvent.getCargo().getType()));
        // TODO add the amount to unload
    }

    public void handleDeparture(DepartureEvent departureEvent) {
        log.info("handleDeparture");
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
