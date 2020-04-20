package org.htwdresden.informatik.eventSourcingSimpleDemo.model;

public class Cargo {
    private String type;

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
}
