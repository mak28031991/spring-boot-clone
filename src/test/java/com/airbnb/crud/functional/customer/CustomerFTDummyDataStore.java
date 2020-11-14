package com.airbnb.crud.functional.customer;

import com.airbnb.crud.TestUtils;
import com.airbnb.crud.controller.model.BaseResponse;
import com.airbnb.crud.util.JsonUtil;

public class CustomerFTDummyDataStore {

    public static BaseResponse getExpectedHappyResponse() {
        String jsonResponsePath = "ftData/CustomerController/createCustomer/happy_response.json";
        String jsonResponse = TestUtils.readTextFile(jsonResponsePath);
        return JsonUtil.jsonDecode(jsonResponse, BaseResponse.class);
    }

    public static String getHappyCreateCustomerRequestJson() {
        String jsonPath="ftData/CustomerController/createCustomer/happy_request.json";
        return TestUtils.readTextFile(jsonPath);
    }

    public static BaseResponse getExpectedHappyCustomerResponseForCity() {
        String jsonResponsePath = "ftData/CustomerController/getCustomersForCity/happy_response.json";
        String jsonResponse = TestUtils.readTextFile(jsonResponsePath);
        return JsonUtil.jsonDecode(jsonResponse, BaseResponse.class);
    }
}
