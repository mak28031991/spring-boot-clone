package com.airbnb.crud.service.booking.impl;

import com.airbnb.crud.airbnbDB.booking.dao.IBookingDao;
import com.airbnb.crud.airbnbDB.enums.BookingStatus;
import com.airbnb.crud.controller.booking.model.CreateBookingRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

class BookingServiceImplUnitTest {

    private final CreateBookingRequest bookingRequest =
            CreateBookingRequest.builder()
                    .bookingStartEpoch(new Date().getTime())
                    .bookingEndEpoch(new Date().getTime())
                    .bookingStatus(BookingStatus.OPEN)
                    .customerId(1212L)
                    .finalCost(1223.0)
                    .houseId(1234L)
                    .build();

    private IBookingDao bookingDao;
    private BookingServiceImpl bookingService;

    @BeforeEach
    public void setup() {
        bookingDao = Mockito.mock(IBookingDao.class);
        bookingService = new BookingServiceImpl(bookingDao);
    }

    @Test
    @DisplayName("Test case for create booking with null value")
    public void createBooking_for_null_value() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            bookingService.createBooking(null);
        });
    }

    @Test
    @DisplayName("Test case for creating booking for valid request")
    void createBooking() {
        try {
            bookingService.createBooking(bookingRequest);
        } catch (final Exception e) {
            Assertions.fail("Test case failed for valid booking request");
        }
    }
}