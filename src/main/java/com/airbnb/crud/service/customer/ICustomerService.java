package com.airbnb.crud.service.customer;

import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;
import com.airbnb.crud.exceptions.EntityNotFoundException;

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
    void createCustomer(@NotNull @Valid final CreateCustomerRequest request);

    /**
     * This method will fetch the customer details for a city.
     * @param cityName String value of cityName
     * @return List of CustomerDetails
     * @see CustomerDetails
     */
    List<CustomerDetails> getCustomersForCity(@NotNull final String cityName) throws EntityNotFoundException;
}
