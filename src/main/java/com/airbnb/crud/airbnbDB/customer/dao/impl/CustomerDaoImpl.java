package com.airbnb.crud.airbnbDB.customer.dao.impl;

import com.airbnb.crud.airbnbDB.customer.dao.ICustomerDao;
import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import com.airbnb.crud.airbnbDB.customer.repository.CustomerRRepository;
import com.airbnb.crud.airbnbDB.customer.repository.CustomerRWRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class CustomerDaoImpl implements ICustomerDao {

    private CustomerRWRepository customerRWRepository;
    private CustomerRRepository customerRRepository;

    @Autowired
    public CustomerDaoImpl(CustomerRWRepository customerRWRepository, CustomerRRepository customerRRepository) {
        this.customerRWRepository = customerRWRepository;
        this.customerRRepository = customerRRepository;
    }

    @Override
    public void createCustomer(@NotNull Customer customer) {
        customerRWRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomersForCity(@NotEmpty String cityName) {
        return customerRRepository.findCustomersByCityName(cityName);
    }

}