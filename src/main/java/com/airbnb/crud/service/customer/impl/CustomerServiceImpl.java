package com.airbnb.crud.service.customer.impl;

import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;
import com.airbnb.crud.service.customer.ICustomerService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Override
    public void createCustomer(@NotNull @Valid CreateCustomerRequest request) {
        //code to save customer will come here
    }

    @Override
    public List<CustomerDetails> getCustomersForCity(@NotNull Integer cityId) {
        return null;
    }
}
