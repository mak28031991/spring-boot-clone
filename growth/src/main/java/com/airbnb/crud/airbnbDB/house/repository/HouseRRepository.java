package com.airbnb.crud.airbnbDB.house.repository;

import com.airbnb.crud.airbnbDB.annotation.ReadOnlyRepository;
import com.airbnb.crud.airbnbDB.house.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ReadOnlyRepository
public interface HouseRRepository extends JpaRepository<House, Long> {
}
