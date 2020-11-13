package com.airbnb.crud.service.customer.impl;

import com.airbnb.crud.airbnbDB.customer.dao.ICustomerDao;
import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;
import com.airbnb.crud.exceptions.EntityNotFoundException;
import com.airbnb.crud.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public void createCustomer(@NotNull @Valid final CreateCustomerRequest request) {
        @NotNull Customer customer = Customer.builder().build();
        customerDao.createCustomer(customer);
    }

    @Override
    public List<CustomerDetails> getCustomersForCity(@NotNull final String cityName) throws EntityNotFoundException {
        final List<Customer> customers = customerDao.getCustomersForCity(cityName);
        if(CollectionUtils.isEmpty(customers)){
            throw new EntityNotFoundException(Customer.class, "cityName", cityName);
        }
        return customers.stream().map( customer -> CustomerDetails.builder().build()).collect(Collectors.toList());
    }
}
