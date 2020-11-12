package com.airbnb.crud.db.repository;

import com.airbnb.crud.db.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRWRepository extends JpaRepository<Booking, Integer> {
}
