package com.airbnb.crud.airbnbDB.enums;

public enum PaymentType {
    CreditCard("CREDIT CARD"),DebitCard("DEBIT CARD");

    String paymentType;
    PaymentType(String s) {
        this.paymentType = s;
    }
}
