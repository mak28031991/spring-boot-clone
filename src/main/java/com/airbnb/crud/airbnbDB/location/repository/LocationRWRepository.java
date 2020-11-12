package com.airbnb.crud.airbnbDB.location.repository;

import com.airbnb.crud.airbnbDB.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRWRepository extends JpaRepository<Location, Integer> {
}
