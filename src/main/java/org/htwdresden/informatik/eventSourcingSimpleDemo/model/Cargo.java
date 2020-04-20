package org.htwdresden.informatik.eventSourcingSimpleDemo.model;

import org.htwdresden.informatik.eventSourcingSimpleDemo.event.ArrivalEvent;
import org.htwdresden.informatik.eventSourcingSimpleDemo.event.LoadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cargo {
    private static final Logger log = LoggerFactory.getLogger(Cargo.class);

    private String type;
    private boolean hasBeenInUK = false;

    public Cargo(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Cargo setType(String type) {
        this.type = type;
        return this;
    }

    public void handleArrival(ArrivalEvent arrivalEvent) {
        log.info("handleArrival");
        handleCargoPassing(arrivalEvent.getPort().getCountry());
    }

    public void handleLoad(LoadEvent loadEvent) {
        log.info("handleLoad");
        handleCargoPassing(loadEvent.getShip().getPort().getCountry());
    }

    private void handleCargoPassing(Country country) {
        log.info("handleCargoPassing");
        if(Country.UK.equals(country)) {
            log.info("set hasBeenInUK to true");
            hasBeenInUK = true;
        }
    }

    public boolean isHasBeenInUK() {
        return hasBeenInUK;
    }
}
