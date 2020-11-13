package com.airbnb.crud.service.booking.impl;

import com.airbnb.crud.airbnbDB.booking.dao.IBookingDao;
import com.airbnb.crud.airbnbDB.booking.entity.Booking;
import com.airbnb.crud.controller.booking.model.CreateBookingRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


class BookingServiceImplUnitTest {

    private final IBookingDao bookingDao = Mockito.mock(IBookingDao.class);
    private final BookingServiceImpl bookingService = new BookingServiceImpl(bookingDao);


    @Test
    @DisplayName("Test case for create booking with null value. This should throw NullPointerException.")
    public void createBookingForNullValue() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            bookingService.createBooking(null);
        });
    }

    @Test
    @DisplayName("Test case for creating booking for valid request")
    void createBookingHappyCase() {
        CreateBookingRequest bookingRequest = BookingServiceTestData.getHappyCreateBookingRequest();
        bookingService.createBooking(bookingRequest);
        Booking expectedArgument = BookingServiceTestData.getHappyBookingArg(bookingRequest);
        //verifying that bookingDao.createBooking() method is called only once with expected argument
        verify(bookingDao, times(1)).createBooking(expectedArgument);
    }
}