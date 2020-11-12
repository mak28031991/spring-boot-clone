package com.airbnb.crud.db.enums;

public enum AccountStatus {
    ACTIVATED("activated"),
    DEACTIVATED("deactivated");

    private final String status;

    AccountStatus(final String status) {
        this.status = status;
    }

    public String getAccountStatus() {
        return status;
    }
}
