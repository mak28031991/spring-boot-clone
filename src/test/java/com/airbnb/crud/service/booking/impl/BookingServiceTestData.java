package com.airbnb.crud.service.booking.impl;

import com.airbnb.crud.airbnbDB.booking.entity.Booking;
import com.airbnb.crud.airbnbDB.enums.BookingStatus;
import com.airbnb.crud.controller.booking.model.CreateBookingRequest;

import java.util.Date;

public class BookingServiceTestData {
    public static CreateBookingRequest getHappyCreateBookingRequest() {
        return CreateBookingRequest.builder()
                .bookingStartEpoch(new Date().getTime())
                .bookingEndEpoch(new Date().getTime())
                .bookingStatus(BookingStatus.OPEN)
                .customerId(1212L)
                .finalCost(1223.0)
                .houseId(1234L)
                .build();
    }

    public static Booking getHappyBookingArg(CreateBookingRequest request) {
        return Booking.builder()
                .bookingEndDate(request.getBookingEndEpoch())
                .bookingStartDate(request.getBookingStartEpoch())
                .bookingStatus(request.getBookingStatus())
                .customerId(request.getCustomerId())
                .finalCost(request.getFinalCost())
                .houseId(request.getHouseId())
                .build();
    }
}
