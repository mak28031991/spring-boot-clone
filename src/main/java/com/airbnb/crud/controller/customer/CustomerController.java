package com.airbnb.crud.controller.customer;

import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.customer.model.CustomerDetails;
import com.airbnb.crud.controller.model.BaseResponse;
import com.airbnb.crud.exceptions.EntityNotFoundException;
import com.airbnb.crud.service.customer.ICustomerService;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public static final String savedSuccessFully = "Customer saved successfully.";
    public static final String customerFetchedSuccessFully = "Customer fetched successfully.";

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "This api will be used to create the customer")
    @Timed(value="create_customer", histogram = true)
    public BaseResponse createCustomer(@Valid @NotNull @RequestBody CreateCustomerRequest request){
        log.info("create customer request ={}",request);
        customerService.createCustomer(request);
        return BaseResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage(savedSuccessFully)
                .data(null)
                .build();
    }

    @RequestMapping(value = "/city/{city_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "This api will be used to get all the customer for a city")
    @Timed(value="get_customer_for_city", histogram = true)
    public BaseResponse getCustomersForCity(@PathVariable("city_name")String cityName) throws EntityNotFoundException {
        log.info("fetching customers for cityName ={}",cityName);
        List<CustomerDetails> customers = customerService.getCustomersForCity(cityName);
        return BaseResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage(customerFetchedSuccessFully)
                .data(customers)
                .build();
    }
}
