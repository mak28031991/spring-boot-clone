package com.airbnb.crud.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class BaseResponse {
    @JsonProperty("status_code") private Integer statusCode;
    @JsonProperty("status_message") private String statusMessage;
    @JsonProperty("data") private Object data;
}
