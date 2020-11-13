package com.airbnb.crud.airbnbDB.host.entity;

import com.airbnb.crud.airbnbDB.enums.AccountType;
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
@Table(name = "host")
@PrimaryKeyJoinColumn(name = "HostID")
public class Host extends Person {

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "RoutingNumber")
    private String routingNumber;

    @Column(name = "AccountTYpe")
    private AccountType accountType;
}
