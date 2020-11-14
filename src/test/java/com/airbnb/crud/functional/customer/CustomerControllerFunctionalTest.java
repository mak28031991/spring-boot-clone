package com.airbnb.crud.functional.customer;

import com.airbnb.crud.AirbnbApplication;
import com.airbnb.crud.controller.model.BaseResponse;
import com.airbnb.crud.functional.BaseTest;
import org.junit.Assert;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AirbnbApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:ftData/CustomerController/cleanup.sql","classpath:ftData/CustomerController/seed.sql"})
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:ftData/CustomerController/cleanup.sql"})
@Category(BaseTest.class)
public class CustomerControllerFunctionalTest extends BaseTest{
    private static final String baseControllerURL = "api/customer";

    @Test
    public void TestCreateCustomerHappyCase(){
        //the dummy request used to test the controller
        String requestJson = CustomerFTDummyDataStore.getHappyCreateCustomerRequestJson();
        //preparing request payload
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(requestJson,headers);
        //calling controller and getting response from API
        ResponseEntity<BaseResponse> actualResponseEntity = restTemplate.postForEntity(getUrl(baseControllerURL+"/create"),request, BaseResponse.class);
        BaseResponse actualResponse = actualResponseEntity.getBody();
        //check if response is successful
        assertTrue(actualResponseEntity.getStatusCode().is2xxSuccessful());
        //expected response from controller
        BaseResponse expectedResponse = CustomerFTDummyDataStore.getExpectedHappyResponse();
        //check if expected response and actual response is correct
        Assert.assertEquals(expectedResponse,actualResponse);
    }

    @Test
    public void TestGetCustomersForCityName(){
        //preparing request payload
        String cityName = "Boston";
        //calling controller and getting response from API
        ResponseEntity<BaseResponse> actualResponseEntity = restTemplate.getForEntity(getUrl(baseControllerURL+"/city/"+cityName), BaseResponse.class);
        BaseResponse actualResponse = actualResponseEntity.getBody();
        BaseResponse expectedResponse = CustomerFTDummyDataStore.getExpectedHappyCustomerResponseForCity();
        //check if expected and actual response is same
        assertEquals(expectedResponse,actualResponse);
    }


}
