package com.airbnb.crud.airbnbDB.booking.entity;

import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import com.airbnb.crud.airbnbDB.house.entity.House;
import com.airbnb.crud.airbnbDB.enums.BookingStatus;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name ="HouseID")
    private House house;

    @ManyToOne(fetch = FetchType.LAZY)  @JoinColumn(name ="CustomerID")
    private Customer customer;

    @Column(name = "FinalCost")
    private String finalCost;

    @CreationTimestamp
    @Column(name = "Timestamp")
    private LocalDateTime createdAt;
}
