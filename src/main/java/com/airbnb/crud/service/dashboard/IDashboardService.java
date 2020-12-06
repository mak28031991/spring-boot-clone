package com.airbnb.crud.service.dashboard;

import com.airbnb.crud.service.dashboard.schema.PanelData;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public interface IDashboardService {
    PanelData getPanelData(String panelId, Map<String, Object> queryParams);
}
