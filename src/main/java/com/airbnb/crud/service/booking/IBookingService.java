package com.airbnb.crud.service.booking;

import com.airbnb.crud.controller.booking.model.CreateBookingRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface IBookingService {
    /**
     * This methid will have the actual implementation of creating a booking.
     * @param request instance of CreateBookingRequest
     * @see CreateBookingRequest
     */
    void createBooking(@NotNull @Valid CreateBookingRequest request);
}