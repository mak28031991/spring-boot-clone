package com.airbnb.crud.service.booking.impl;

import com.airbnb.authy.model.AuthRequest;
import com.airbnb.authy.service.auth.IAuthService;
import com.airbnb.crud.airbnbDB.booking.dao.IBookingDao;
import com.airbnb.crud.airbnbDB.booking.entity.Booking;
import com.airbnb.crud.controller.booking.model.CreateBookingRequest;
import com.airbnb.crud.exceptions.AirbnbException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


class BookingServiceImplUnitTest {

    private final IBookingDao bookingDao = Mockito.mock(IBookingDao.class);
    private final IAuthService authService = Mockito.mock(IAuthService.class);
    private final BookingServiceImpl bookingService = new BookingServiceImpl(bookingDao,authService);


    @Test
    @DisplayName("Test case for create booking with null value. This should throw NullPointerException.")
    public void createBookingForNullValue() {
        when(authService.isAuth(any(AuthRequest.class))).thenReturn(true);
        Assertions.assertThrows(NullPointerException.class, () -> {
            bookingService.createBooking(null);
        });
    }

    @Test
    @DisplayName("Test case for creating booking for valid request")
    void createBookingHappyCase() throws AirbnbException {
        CreateBookingRequest bookingRequest = BookingServiceTestData.getHappyCreateBookingRequest();
        when(authService.isAuth(any(AuthRequest.class))).thenReturn(true);
        bookingService.createBooking(bookingRequest);
        Booking expectedArgument = BookingServiceTestData.getHappyBookingArg(bookingRequest);
        //verifying that bookingDao.createBooking() method is called only once with expected argument
        verify(bookingDao, times(1)).createBooking(expectedArgument);
    }
}