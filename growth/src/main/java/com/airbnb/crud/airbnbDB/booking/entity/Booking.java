package com.airbnb.crud.airbnbDB.booking.entity;

import com.airbnb.crud.airbnbDB.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "BookingStartDate")
    private Long bookingStartDate;

    @Column(name = "BookingEndDate")
    private Long bookingEndDate;

    @Column(name = "BookingStatus")
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Column(name = "HouseID")
    private Long houseId;

    @Column(name = "CustomerID")
    private Long customerId;

    @Column(name = "FinalCost")
    private Double finalCost;

    @CreationTimestamp
    @Column(name = "Timestamp")
    private LocalDateTime createdAt;
}
