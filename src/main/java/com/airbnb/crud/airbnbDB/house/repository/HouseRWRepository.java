package com.airbnb.crud.airbnbDB.house.repository;

import com.airbnb.crud.airbnbDB.house.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRWRepository extends JpaRepository<House, Integer> {
}
