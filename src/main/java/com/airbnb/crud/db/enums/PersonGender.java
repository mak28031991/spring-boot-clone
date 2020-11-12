package com.airbnb.crud.db.enums;

public enum PersonGender {
    MALE("male"),
    FEMALE("female"),
    OTHERS("other");

    private final String gender;

    PersonGender(final String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
