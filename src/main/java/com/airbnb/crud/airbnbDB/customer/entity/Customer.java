package com.airbnb.crud.airbnbDB.customer.entity;

import com.airbnb.crud.airbnbDB.enums.PaymentType;
import com.airbnb.crud.airbnbDB.person.entity.Person;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "CustomerID")
public class Customer extends Person {

    @Column(name = "CardNumber")
    private String cardNumber;

    @Column(name = "SecurityCode")
    private String securityCode;

    @Column(name = "NameOnCard")
    private String nameOnCard;

    @Column(name = "PaymentType")
    private PaymentType paymentType;
}
