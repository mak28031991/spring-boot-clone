package com.airbnb.crud.db.entity;

import com.airbnb.crud.db.enums.Availability;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Builder
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HouseID", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "StreetNumber")
    private String streetNumber;

    @Column(name = "StreetName")
    private String streetName;

    @Column(name = "AptNumber")
    private String apartmentNumber;

    @Column(name = "CostPerNight")
    private String costPerNight;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "LocationID", table = "location")
    private Location location;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "HostID", table = "host")
    private Host host;

    @Column(name = "Availability")
    private Availability availability;
}
