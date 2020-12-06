package com.airbnb.crud.airbnbDB.booking.repository;

import com.airbnb.crud.airbnbDB.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRWRepository extends JpaRepository<Booking, Integer> {
}
