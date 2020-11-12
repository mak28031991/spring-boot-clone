package com.airbnb.crud.db.enums;

public enum Availability {
    AVAILABLE("available"),
    NOT_AVAILABLE("not-available");

    private final String availability;

    Availability(final String availability) {
        this.availability = availability;
    }

    public String getAvailability() {
        return availability;
    }

}
