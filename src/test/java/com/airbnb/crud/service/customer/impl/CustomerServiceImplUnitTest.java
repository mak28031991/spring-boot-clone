package com.airbnb.crud.service.customer.impl;

import com.airbnb.crud.airbnbDB.customer.dao.impl.CustomerDaoImpl;
import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import com.airbnb.crud.airbnbDB.enums.AccountStatus;
import com.airbnb.crud.airbnbDB.enums.PaymentType;
import com.airbnb.crud.airbnbDB.enums.PersonGender;
import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;
import com.airbnb.crud.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

class CustomerServiceImplUnitTest {

    final CreateCustomerRequest customerRequest = CreateCustomerRequest.builder()
            .cardNumber("123ABC456")
            .accountStatus(AccountStatus.deactivated.name())
            .birthDate(String.valueOf(new Date().getTime()))
            .emailID("test@gmail.com")
            .firstName("test")
            .gender(PersonGender.FEMALE)
            .lastName("test")
            .nameOnCard("test test")
            .password("password")
            .paymentType(PaymentType.CreditCard.name())
            .phoneNumber("9898989898")
            .photo("some_photo_url")
            .securityCode("!@#$%^&*()")
            .build();

    private CustomerServiceImpl customerService;
    private CustomerDaoImpl customerDao;

    @BeforeEach
    public void setup() {
        customerDao = Mockito.mock(CustomerDaoImpl.class);
        customerService = new CustomerServiceImpl(customerDao);
    }

    @Test
    @DisplayName("Create customer for null input")
    public void createCustomer_with_null_input() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            customerService.createCustomer(null);
        });
    }

    @Test
    @DisplayName("Success test case for create customer")
    public void createCustomer_with_success_input() {
        try {
            customerService.createCustomer(customerRequest);
        } catch (final Exception e) {
            Assertions.fail("Test case fail for creating of customer", e);
        }
    }

    @Test
    @DisplayName("Test case for null city value")
    public void getCustomersForCity_for_null_city_value() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            customerService.getCustomersForCity(null);
        });
    }

    @Test
    @DisplayName("Test case for empty city value")
    public void getCustomerForCity_for_empty_city_value() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            customerService.getCustomersForCity("");
        });
    }

    @Test
    @DisplayName("Test case for valid city value")
    public void getCustomerForCity_for_valid_city_value() {
        when(customerDao.getCustomersForCity("Boston")).thenReturn(Collections.singletonList(Customer.builder().build()));
        try {
            final List<CustomerDetails> customers = customerService.getCustomersForCity("Boston");
            if (customers.size() <= 0) {
                Assertions.fail("Test case failed while fetching customers for valid city");
            }
        } catch (final EntityNotFoundException e) {
            Assertions.fail("Test case failed while fetching customers for valid city", e);
        } catch (final Exception e) {
            Assertions.fail("Test case failed while fetching customers for valid city", e);
        }
    }
}