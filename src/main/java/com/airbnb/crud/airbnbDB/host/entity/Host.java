package com.airbnb.crud.airbnbDB.host.entity;

import com.airbnb.crud.airbnbDB.enums.AccountType;
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
@Table(name = "host")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HostID", updatable = false, nullable = false)
    private Long hostID;

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "RoutingNumber")
    private String routingNumber;

    @Column(name = "AccountTYpe")
    private AccountType accountType;
}
