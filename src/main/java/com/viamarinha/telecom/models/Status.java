package com.viamarinha.telecom.models;

public class Status {

    private int id;
    private boolean active;
    private boolean inService;
    private boolean functional;

    public Status() {
    }

    public Status(int id, boolean active, boolean inService, boolean functional) {
        this.id = id;
        this.active = active;
        this.inService = inService;
        this.functional = functional;
    }

    public Status(boolean active, boolean inService, boolean functional) {
        this.active = active;
        this.inService = inService;
        this.functional = functional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }
}
