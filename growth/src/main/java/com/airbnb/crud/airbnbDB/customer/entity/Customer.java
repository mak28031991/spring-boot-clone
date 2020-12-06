package com.airbnb.crud.airbnbDB.customer.entity;

import com.airbnb.crud.airbnbDB.person.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "customer_id")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Person {

    @Column(name = "CardNumber")
    private String cardNumber;

    @Column(name = "SecurityCode")
    private String securityCode;

    @Column(name = "NameOnCard")
    private String nameOnCard;

    @Column(name = "PaymentType", length=45)
    private String paymentType;
}
