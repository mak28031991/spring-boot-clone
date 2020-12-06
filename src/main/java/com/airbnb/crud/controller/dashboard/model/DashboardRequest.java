package com.airbnb.crud.controller.dashboard.model;

import com.airbnb.crud.controller.customer.model.CustomerAttributes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class DashboardRequest {
    @JsonProperty("query_params")
    private Map<String,Object> queryParams; // we can pass pagination, sort, where params etc here
}

