package com.airbnb.crud.airbnbDB.booking.dao.impl;

import com.airbnb.crud.airbnbDB.booking.dao.IBookingDao;
import com.airbnb.crud.airbnbDB.booking.entity.Booking;
import com.airbnb.crud.airbnbDB.booking.repository.BookingRRepository;
import com.airbnb.crud.airbnbDB.booking.repository.BookingRWRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class BookingDaoImpl implements IBookingDao{

    private final BookingRRepository bookingRRepository;
    private final BookingRWRepository bookingRWRepository;

    @Autowired
    public BookingDaoImpl(BookingRRepository bookingRRepository, BookingRWRepository bookingRWRepository) {
        this.bookingRRepository = bookingRRepository;
        this.bookingRWRepository = bookingRWRepository;
    }

    @Override
    public Booking createBooking(@NotNull Booking booking) {
        return bookingRWRepository.save(booking);
    }
}
