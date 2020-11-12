package com.airbnb.crud.db.enums;

public enum AccountType {
    CURRENT("current"),
    SAVING("saving");

    private String type;

    AccountType(final String type) {
        this.type = type;
    }

    public String getAccountType() {
        return type;
    }
}
