package com.airbnb.crud.db.enums;

public enum PaymentType {

    CARD("card"),
    NET_BANKING("net-banking");

    private final String type;

    PaymentType(final String type) {
        this.type = type;
    }

    public String getPaymentType() {
        return type;
    }
}
