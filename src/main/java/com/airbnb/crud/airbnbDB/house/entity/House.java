package com.airbnb.crud.airbnbDB.house.entity;

import com.airbnb.crud.airbnbDB.location.entity.Location;
import com.airbnb.crud.airbnbDB.enums.Availability;
import com.airbnb.crud.airbnbDB.host.entity.Host;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "LocationID")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "HostID")
    private Host hostID;

    @Column(name = "Availability")
    private Availability availability;
}
