package com.airbnb.crud.airbnbDB.customer.repository;

import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRWRepository extends JpaRepository<Customer, Long> {
}
