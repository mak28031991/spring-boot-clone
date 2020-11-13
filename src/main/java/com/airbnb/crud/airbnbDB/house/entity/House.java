package com.airbnb.crud.airbnbDB.house.entity;

import com.airbnb.crud.airbnbDB.enums.Availability;
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
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HouseID", updatable = false, nullable = false)
    private Long houseID;

    @Column(name = "StreetNumber")
    private String streetNumber;

    @Column(name = "StreetName")
    private String streetName;

    @Column(name = "AptNumber")
    private String apartmentNumber;

    @Column(name = "CostPerNight")
    private String costPerNight;

    @Column(name = "LocationID")
    private Long locationId;

    @Column(name = "HostID")
    private Long hostID;

    @Column(name = "Availability")
    private Availability availability;
}
