package com.airbnb.crud.service.customer.impl;

import com.airbnb.authy.model.AuthRequest;
import com.airbnb.authy.service.auth.IAuthService;
import com.airbnb.crud.airbnbDB.customer.dao.ICustomerDao;
import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;
import com.airbnb.crud.exceptions.AirbnbException;
import com.airbnb.crud.exceptions.EntityNotFoundException;
import com.airbnb.crud.service.customer.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerDao customerDao;
    private final IAuthService authService;

    @Autowired
    public CustomerServiceImpl(final ICustomerDao customerDao, IAuthService authService) {
        this.customerDao = customerDao;
        this.authService = authService;
    }

    @Override
    @Transactional
    public Customer createCustomer(@NotNull @Valid final CreateCustomerRequest request) throws AirbnbException {
        //authorize before making an entry
        AuthRequest authRequest = new AuthRequest();
        if(!authService.isAuth(authRequest)){
            throw new AirbnbException("UnAuthorized Access", HttpStatus.FORBIDDEN);
        }
        @NotNull Customer customer = Customer.builder()
                .cardNumber(request.getCardNumber())
                .accountStatus(request.getAccountStatus())
                .birthDate(request.getBirthDate())
                .emailID(request.getEmailID())
                .firstName(request.getFirstName())
                .gender(request.getGender())
                .lastName(request.getLastName())
                .nameOnCard(request.getNameOnCard())
                .password(request.getPassword())
                .paymentType(request.getPaymentType())
                .phoneNumber(request.getPhoneNumber())
                .photo(request.getPhoto())
                .securityCode(request.getSecurityCode())
                .build();
        return customerDao.createCustomer(customer);
    }

    @Override
    public List<CustomerDetails> getCustomersForCity(@NotNull final String cityName) throws EntityNotFoundException {
        final List<Customer> customers = customerDao.getCustomersForCity(cityName);
        if(CollectionUtils.isEmpty(customers)){
            log.warn("customers not found for cityName={}",cityName);
            throw new EntityNotFoundException(Customer.class, "cityName", cityName);
        }
        return customers.stream().map(this::createCustomerDetails).collect(Collectors.toList());
    }

    private CustomerDetails createCustomerDetails(final Customer customer) {
        return CustomerDetails.builder()
                .customerId(customer.getId())
                .accountStatus(customer.getAccountStatus())
                .birthDate(customer.getBirthDate())
                .emailID(customer.getEmailID())
                .firstName(customer.getFirstName())
                .gender(customer.getGender())
                .lastName(customer.getLastName())
                .nameOnCard(customer.getNameOnCard())
                .password(customer.getPassword())
                .paymentType(customer.getPaymentType())
                .phoneNumber(customer.getPhoneNumber())
                .photo(customer.getPhoto())
                .securityCode(customer.getSecurityCode())
                .build();
    }
}
