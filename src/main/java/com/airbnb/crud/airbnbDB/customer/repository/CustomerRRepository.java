package com.airbnb.crud.airbnbDB.customer.repository;

import com.airbnb.crud.airbnbDB.annotation.ReadOnlyRepository;
import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ReadOnlyRepository
public interface CustomerRRepository extends JpaRepository<Customer, Long> {
    @Query("make sure this query is using index properly")
    List<Customer> findCustomersByCityName(@Param("city_name") String cityName);
}
