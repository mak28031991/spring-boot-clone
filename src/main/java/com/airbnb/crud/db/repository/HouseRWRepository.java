package com.airbnb.crud.db.repository;

import com.airbnb.crud.db.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRWRepository extends JpaRepository<House, Integer> {
}
