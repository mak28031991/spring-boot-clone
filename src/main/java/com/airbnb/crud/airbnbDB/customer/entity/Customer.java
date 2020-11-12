package com.airbnb.crud.airbnbDB.customer.entity;

import com.airbnb.crud.airbnbDB.enums.PaymentType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID", updatable = false, nullable = false)
    private Integer customerID;

    @Column(name = "CardNumber")
    private String cardNumber;

    @Column(name = "SecurityCode")
    private String securityCode;

    @Column(name = "NameOnCard")
    private String nameOnCard;

    @Column(name = "PaymentType")
    private PaymentType paymentType;
}
