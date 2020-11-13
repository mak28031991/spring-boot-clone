package com.airbnb.crud.service.booking.impl;

import com.airbnb.crud.airbnbDB.booking.dao.IBookingDao;
import com.airbnb.crud.airbnbDB.booking.entity.Booking;
import com.airbnb.crud.controller.booking.model.CreateBookingRequest;
import com.airbnb.crud.service.booking.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class BookingServiceImpl implements IBookingService {

    private final IBookingDao bookingDao;

    @Autowired
    public BookingServiceImpl(IBookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createBooking(@NotNull @Valid final CreateBookingRequest request) {
        //creating booking entry
        @NotNull Booking booking = getBookingFromRequest(request);
        bookingDao.createBooking(booking);
    }

    private Booking getBookingFromRequest(CreateBookingRequest request) {
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
