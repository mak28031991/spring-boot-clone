package com.airbnb.crud.service.booking.impl;

import com.airbnb.crud.controller.booking.model.CreateBookingRequest;
import com.airbnb.crud.service.booking.IBookingService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class BookingServiceImpl implements IBookingService {

    @Override
    public void createBooking(@NotNull @Valid CreateBookingRequest request) {
        // actual code to create booking will come here
    }
}
