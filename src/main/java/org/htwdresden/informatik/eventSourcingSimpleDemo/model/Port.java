package org.htwdresden.informatik.eventSourcingSimpleDemo.model;

public class Port {

    public static final Port AT_SEA = new Port("", Country.NONE);

    private String name;
    private Country country;

    public Port(String name, Country country) {
        this.name = name;
        this.country = country;
    }

}
