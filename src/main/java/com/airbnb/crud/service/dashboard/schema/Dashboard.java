package com.airbnb.crud.service.dashboard.schema;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement(name = "dashboard")
public class Dashboard {

    @XmlJavaTypeAdapter(DashboardPanelAdapter.class)
    @XmlElement(name = "dashboard_panels")
    private Map<String, DashboardPanel> panels;

    public Map<String, DashboardPanel> getPanels() {
        return panels;
    }
}
