package com.airbnb.crud.airbnbDB.house.entity;

import com.airbnb.crud.airbnbDB.enums.Availability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "house")
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

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
    @Enumerated(EnumType.STRING)
    private Availability availability;
}
