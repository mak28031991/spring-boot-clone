package com.airbnb.crud.db.repository;

import com.airbnb.crud.db.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRWRepository extends JpaRepository<Location, Integer> {
}
