package com.airbnb.crud.airbnbDB.customer.entity;

import com.airbnb.crud.airbnbDB.person.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "CustomerID")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Person {

    @Column(name = "CardNumber")
    private String cardNumber;

    @Column(name = "SecurityCode")
    private String securityCode;

    @Column(name = "NameOnCard")
    private String nameOnCard;

    @Column(name = "PaymentType")
    //@Enumerated(EnumType.STRING) @TODO change this to enum
    private String paymentType;
}
