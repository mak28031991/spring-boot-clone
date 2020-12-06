package com.airbnb.crud.airbnbDB.customer.dao;

import com.airbnb.crud.airbnbDB.customer.entity.Customer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ICustomerDao {
    /**
     * This method creates a customer and save the entries in database.
     * @param customer instance of customer
     */
    Customer createCustomer(@NotNull Customer customer);

    /**
     * This method fetches the list of customer based on cityName
     * @param cityName string value of cityName
     * @return List of customer
     */
    List<Customer> getCustomersForCity(@NotEmpty String cityName);

}
