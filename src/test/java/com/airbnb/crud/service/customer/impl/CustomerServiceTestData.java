package com.airbnb.crud.service.customer.impl;

import com.airbnb.crud.airbnbDB.customer.entity.Customer;
import com.airbnb.crud.airbnbDB.enums.AccountStatus;
import com.airbnb.crud.airbnbDB.enums.PaymentType;
import com.airbnb.crud.airbnbDB.enums.PersonGender;
import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;
import org.testcontainers.shaded.com.google.common.collect.ImmutableList;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceTestData {
    public static CreateCustomerRequest getHappyCreateCustomerRequest() {
        return CreateCustomerRequest.builder()
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
    }

    public static Customer getExpectedCustomer(CreateCustomerRequest request) {
        return Customer.builder()
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
    }

    public static List<Customer> getHappyCustomersForCity() {
        return ImmutableList.of(
                Customer.builder().personID(123L).build(),
                Customer.builder().personID(456L).build()
        );
    }

    public static List<CustomerDetails> getExpectedCustomersForHappyCityName(List<Customer> dummyCustomers) {
        return dummyCustomers.stream().map( c -> CustomerDetails.builder().customerId(c.getPersonID()).build()).collect(Collectors.toList());
    }
}
