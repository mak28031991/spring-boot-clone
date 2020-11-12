package com.airbnb.crud.db.repository;

import com.airbnb.crud.db.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRWRepository extends JpaRepository<Customer, Integer> {
}
