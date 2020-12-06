package com.airbnb.crud.airbnbDB.booking.dao;

import com.airbnb.crud.airbnbDB.booking.entity.Booking;

import javax.validation.constraints.NotNull;

public interface IBookingDao {
    /**
     * This method takes booking as object and store it into the database.
     * @param booking instance of booking
     * @see Booking
     */
    Booking createBooking(@NotNull Booking booking);
}
