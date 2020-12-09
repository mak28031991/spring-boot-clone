package com.airbnb.crud.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DemandResponse {
    @JsonProperty("status_code") private Integer statusCode;
    @JsonProperty("status_message") private String statusMessage;
    @JsonProperty("data") private DemandData data; // actual data from service API
}
