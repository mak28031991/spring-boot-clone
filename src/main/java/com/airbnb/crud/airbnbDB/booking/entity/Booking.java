package com.airbnb.crud.airbnbDB.booking.entity;

import com.airbnb.crud.airbnbDB.enums.BookingStatus;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingID", updatable = false, nullable = false)
    private Integer bookingId;

    @Column(name = "BookingStartDate")
    private String bookingStartDate;

    @Column(name = "BookingEndDate")
    private String bookingEndDate;

    @Column(name = "BookingStatus")
    private BookingStatus bookingStatus;

    @Column(name = "HouseID")
    private Long houseId;

    @Column(name = "CustomerID")
    private Long customerId;

    @Column(name = "FinalCost")
    private String finalCost;

    @CreationTimestamp
    @Column(name = "Timestamp")
    private LocalDateTime createdAt;
}
