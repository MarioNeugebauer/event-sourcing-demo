package org.htwdresden.informatik.eventSourcingSimpleDemo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Port {

    private static final Logger log = LoggerFactory.getLogger(Port.class);

    public static final Port AT_SEA = new Port("", Country.NONE);

    private String name;
    private Country country;

    public Port(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }
}
