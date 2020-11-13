package com.airbnb.crud.service.customer;

import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ICustomerService {
    /**
     * This method will create a customer.
     * @param request instance of CreateCustomerRequest
     * @see CustomerDetails
     * @see CreateCustomerRequest
     */
    void createCustomer(@NotNull @Valid CreateCustomerRequest request);

    /**
     * This methd will fetch the customer details for a city.
     * @param cityId Integer value of cityID
     * @return List of CustomerDetails
     * @see CustomerDetails
     */
    List<CustomerDetails> getCustomersForCity(@NotNull Integer cityId);
}
