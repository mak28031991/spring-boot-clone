package com.airbnb.crud.db.entity;

import com.airbnb.crud.db.enums.BookingStatus;
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
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingID", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "BookingStartDate")
    private String startDate;

    @Column(name = "BookingEndDate")
    private String endDate;

    @Column(name = "BookingStatus")
    private BookingStatus bookingStatus;

    @Column(name = "HouseID")
    private House house;

    @Column(name = "CustomerID")
    private Customer customer;

    @Column(name = "FinalCost")
    private String finalCost;

    // in ER diagram time stamp is also given, not sure whats the use of it
}
