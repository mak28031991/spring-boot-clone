package com.airbnb.crud.service.dashboard.impl;

import com.airbnb.crud.airbnbDB.dashboard.dao.IDashboardDao;
import com.airbnb.crud.service.dashboard.IDashboardService;
import com.airbnb.crud.service.dashboard.schema.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DashboardService implements IDashboardService {

    private final IDashboardDao dashboardDao;

    @Autowired
    public DashboardService(IDashboardDao dashboardDao) {
        this.dashboardDao = dashboardDao;
    }

    @Override
    public PanelData getPanelData(String panelId, Map<String, Object> queryParams) {
        DashboardProvider dashboardProvider = DashboardProvider.getDashboardProvider();
        DashboardPanel panel = dashboardProvider.getDashboard().getPanels().get(panelId);
        log.info("panel={}",panel);
        PanelHeaders panelHeaders = panel.getPanelHeaders();
        log.info("panelHeaders ={}", panelHeaders);
        String sql = panel.getSqlQuery();
        sql = replaceParams(sql, queryParams);
        log.info("final Query = {}",sql);
        List<Object[]> panelRows = dashboardDao.queryDB(sql);
        return generatePanelData(panelHeaders, panelRows);
    }

    private PanelData generatePanelData(PanelHeaders panelHeaders, List<Object[]> panelRows) {
        List<PanelColumn> columns = panelHeaders.getHeaders();
        //sorting the column by orderId
        columns.sort(Comparator.comparing(PanelColumn::getColumnOrder));
        List<List<Object>> data = panelRows.stream().map( row -> Arrays.asList(row.clone())).collect(Collectors.toList());
        List<Map<String, String>> headers = generateHeaders(columns);
        return PanelData.builder().data(data).headers(headers).build();
    }

    private List<Map<String, String>> generateHeaders(List<PanelColumn> columns) {
        List<Map<String, String>> headers = Lists.newArrayListWithCapacity(columns.size());
        for(PanelColumn column : columns){
            Map<String, String> colDetails = Maps.newHashMapWithExpectedSize(2);
            colDetails.put("name", column.getDisplayName());
            colDetails.put("component_type", column.getColumnType());
            colDetails.put("is_visible", column.getIsVisible());
            headers.add(colDetails);
        }
        return headers;
    }

    private String replaceParams(String sql, Map<String, Object> queryParams) {
        for(String param : queryParams.keySet()){
            sql = sql.replaceAll(param, String.valueOf(queryParams.get(param)));
        }
        return sql;
    }
}
