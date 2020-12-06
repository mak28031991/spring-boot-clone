package com.airbnb.crud.service.customer.impl;

import com.airbnb.authy.model.AuthRequest;
import com.airbnb.authy.service.auth.IAuthService;
import com.airbnb.crud.airbnbDB.customer.dao.ICustomerDao;
import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;
import com.airbnb.crud.exceptions.AirbnbException;
import com.airbnb.crud.exceptions.EntityNotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class CustomerServiceImplUnitTest {

    private final ICustomerDao customerDao = Mockito.mock(ICustomerDao.class);
    private final IAuthService authService = Mockito.mock(IAuthService.class);
    private final CustomerServiceImpl customerService = new CustomerServiceImpl(customerDao,authService);;

    @Test
    @DisplayName("Create customer for null input. This should throw NullPointerException")
    public void createCustomerWithNullInput() {
        when(authService.isAuth(any(AuthRequest.class))).thenReturn(true);
        Assertions.assertThrows(NullPointerException.class, () -> {
            customerService.createCustomer(null);
        });
    }

    @Test
    @DisplayName("Success test case for create customer")
    public void createCustomerWithHappyCase() throws AirbnbException {
        when(authService.isAuth(any(AuthRequest.class))).thenReturn(true);
        CreateCustomerRequest customerRequest = CustomerServiceTestData.getHappyCreateCustomerRequest();
        customerService.createCustomer(customerRequest);
        Customer expectedArgument = CustomerServiceTestData.getExpectedCustomer(customerRequest);
        //verify that customerDao.createCustomer() is called once with expected argument.
        verify(customerDao,times(1)).createCustomer(expectedArgument);
    }

    @Test
    @DisplayName("Test case for null city name. This should throw EntityNotFoundException.")
    public void getCustomersForCityForNullCityName() {
        //mocking that when customerDao.getCustomersForCity(null) is called then empty list will be returned
        Mockito.when(customerDao.getCustomersForCity(null)).thenReturn(Collections.emptyList());
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            customerService.getCustomersForCity(null);
        });
        // verify that customerDao.getCustomersForCity() is called once with correct argument
        verify(customerDao,times(1)).getCustomersForCity(null);
    }

    @Test
    @DisplayName("Test ase for empty city value. This should throw EntityNotFoundException.")
    public void getCustomerForCityForEmptyCityName() {
        //mocking that when customerDao.getCustomersForCity("") is called then empty list will be returned
        Mockito.when(customerDao.getCustomersForCity("")).thenReturn(Collections.emptyList());
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            customerService.getCustomersForCity("");
        });
        // verify that customerDao.getCustomersForCity("") is called once with correct argument
        verify(customerDao,times(1)).getCustomersForCity("");
    }

    @Test
    @DisplayName("Test case for valid city value")
    public void getCustomerForCityForValidCityName() throws EntityNotFoundException {
        List<Customer> dummyCustomers = CustomerServiceTestData.getHappyCustomersForCity();
        //when customerDao.getCustomersForCity("Boston") is called then return the dummyCustomers
        when(customerDao.getCustomersForCity("Boston")).thenReturn(dummyCustomers);
        //expected customers to be returned by the service
        List<CustomerDetails> expectedCustomers = CustomerServiceTestData.getExpectedCustomersForHappyCityName(dummyCustomers);
        //actual customers returned by service
        final List<CustomerDetails> actualCustomers = customerService.getCustomersForCity("Boston");
        Assert.assertEquals(expectedCustomers, actualCustomers);
        // verify that customerDao.getCustomersForCity() is called with correct argument
        verify(customerDao,times(1)).getCustomersForCity("Boston");
    }
}