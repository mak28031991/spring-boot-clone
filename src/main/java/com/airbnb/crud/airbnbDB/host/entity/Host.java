package com.airbnb.crud.airbnbDB.host.entity;

import com.airbnb.crud.airbnbDB.enums.AccountType;
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
@Table(name = "host")
@PrimaryKeyJoinColumn(name = "host_id")
@NoArgsConstructor
@AllArgsConstructor
public class Host extends Person {

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "RoutingNumber")
    private String routingNumber;

    @Column(name = "AccountTYpe")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
