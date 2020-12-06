package com.airbnb.crud.service.booking.impl;

import com.airbnb.authy.model.AuthRequest;
import com.airbnb.authy.service.auth.IAuthService;
import com.airbnb.crud.airbnbDB.booking.dao.IBookingDao;
import com.airbnb.crud.airbnbDB.booking.entity.Booking;
import com.airbnb.crud.controller.booking.model.CreateBookingRequest;
import com.airbnb.crud.exceptions.AirbnbException;
import com.airbnb.crud.service.booking.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements IBookingService {

    private final IBookingDao bookingDao;
    private final IAuthService authService;

    @Autowired
    public BookingServiceImpl(IBookingDao bookingDao, IAuthService authService) {
        this.bookingDao = bookingDao;
        this.authService = authService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Booking createBooking(@NotNull @Valid final CreateBookingRequest request) throws AirbnbException {
        //authorize before making an entry
        AuthRequest authRequest = new AuthRequest();
        if(!authService.isAuth(authRequest)){
            throw new AirbnbException("UnAuthorized Access", HttpStatus.FORBIDDEN);
        }
        //creating booking entry
        @NotNull Booking booking = getBookingFromRequest(request);
        return bookingDao.createBooking(booking);
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
