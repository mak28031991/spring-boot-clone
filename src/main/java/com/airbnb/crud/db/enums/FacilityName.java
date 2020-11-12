package com.airbnb.crud.db.enums;

public enum FacilityName {
    TWO_WHEELER_PARKING("two-wheeler-parking"),
    FUR_WHEELER_PARKING("four-wheeler-parking"),
    SWIMMING_POOL("swimming-pool");

    private final String facility;

    FacilityName(final String facility) {
        this.facility = facility;
    }

    public String getFacility() {
        return facility;
    }
}
