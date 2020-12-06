package com.airbnb.crud.service.booking;

import com.airbnb.crud.airbnbDB.booking.entity.Booking;
import com.airbnb.crud.controller.booking.model.CreateBookingRequest;
import com.airbnb.crud.exceptions.AirbnbException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface IBookingService {
    /**
     * This method will have the actual implementation of creating a booking.
     * @param request instance of CreateBookingRequest
     * @see CreateBookingRequest
     */
    Booking createBooking(@NotNull @Valid final CreateBookingRequest request) throws AirbnbException;
}
