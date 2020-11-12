package com.airbnb.crud.controller.booking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Validated
public class CreateBookingRequest {
    @NotNull @JsonProperty("booking_start_epoch") private Long bookingStartEpoch;
    @NotNull @JsonProperty("booking_end_epoch") private Long bookingEndEpoch;
    @NotNull @JsonProperty("booking_status") private String bookingStatus;
    @NotNull @JsonProperty("final_cost") private Double finalCost;
    @NotNull @JsonProperty("created_at_epoch") private Long createdAtEpoch;
    @NotNull @JsonProperty("customer_id") private Long customerId;
}
