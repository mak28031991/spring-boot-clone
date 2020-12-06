package com.airbnb.crud.service.dashboard.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PanelData {
    @JsonProperty("headers")
    List<Map<String, String>> headers;
    @JsonProperty("data")
    List<List<Object>> data;
}
