package com.airbnb.crud.controller.dashboard;

import com.airbnb.crud.controller.customer.model.CustomerDetails;
import com.airbnb.crud.controller.dashboard.model.DashboardRequest;
import com.airbnb.crud.controller.model.BaseResponse;
import com.airbnb.crud.exceptions.EntityNotFoundException;
import com.airbnb.crud.service.dashboard.IDashboardService;
import com.airbnb.crud.service.dashboard.schema.PanelData;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/dashboard")
@Slf4j
public class DashboardController {

    private IDashboardService dashboardService;

    @Autowired
    public DashboardController(IDashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(value = "/panel/{panel_id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "This api will be used to get all the data for panel")
    public BaseResponse getPanelData(@PathVariable("panel_id")String panelId, @RequestBody DashboardRequest request) {
        log.info("fetching data for panel_id ={} and request={} ",panelId, request);
        PanelData panelData = dashboardService.getPanelData(panelId,request.getQueryParams());
        return BaseResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .statusMessage("Sent panel data Successfully.")
                .data(panelData)
                .build();
    }
}
