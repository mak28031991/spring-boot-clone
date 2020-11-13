package com.airbnb.crud.service.customer.impl;

import com.airbnb.crud.airbnbDB.customer.dao.impl.CustomerDaoImpl;
import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import com.airbnb.crud.airbnbDB.enums.AccountStatus;
import com.airbnb.crud.airbnbDB.enums.PaymentType;
import com.airbnb.crud.airbnbDB.enums.PersonGender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

class CustomerServiceImplUnitTest {
    final Customer customer = Customer.builder()
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
    private CustomerDaoImpl customerDao;

    @BeforeEach
    public void setup() {
        customerDao = Mockito.mock(CustomerDaoImpl.class);
    }

    @Test
    @DisplayName("Create customer for null input")
    public void createCustomer_with_null_input() {
        try {
            customerDao.createCustomer(null);
        } catch (final Exception e) {
            Assertions.fail("Test case fail while creating null customer", e);
        }
    }

    @Test
    @DisplayName("Success test case for create customer")
    public void createCustomer_with_success_input() {
        try {
            customerDao.createCustomer(customer);
        } catch (final Exception e) {
            Assertions.fail("Test case fail for creating of customer", e);
        }
    }

    @Test
    void getCustomersForCity() {
    }
}