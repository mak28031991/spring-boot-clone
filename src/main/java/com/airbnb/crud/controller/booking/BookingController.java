package com.airbnb.crud.controller.booking;

import com.airbnb.crud.controller.booking.model.CreateBookingRequest;
import com.airbnb.crud.controller.customer.model.CreateCustomerRequest;
import com.airbnb.crud.controller.model.BaseResponse;
import com.airbnb.crud.service.booking.IBookingService;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@CrossOrigin
@RequestMapping("/api/booking")
@Slf4j
public class BookingController {

    public static final String createdSuccessFully = "Booking created successfully.";

    private IBookingService bookingService;

    @Autowired
    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "This api will be used to create the booking")
    @Timed(value="create_booking", histogram = true)
    public BaseResponse createBooking(@Valid @NotNull @RequestBody CreateBookingRequest request){
        log.info("create booking request ={}",request);
        bookingService.createBooking(request);
        return BaseResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage(createdSuccessFully)
                .data(null)
                .build();
    }
}