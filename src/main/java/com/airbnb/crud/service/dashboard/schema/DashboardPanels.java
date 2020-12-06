package com.airbnb.crud.service.dashboard.schema;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dashboard_panels")
public class DashboardPanels {
    private List<DashboardPanel> panels;

    @XmlElement(name="dashboard_panel")
    public List<DashboardPanel> getPanels() {
        return panels;
    }
    public void setPanels(List<DashboardPanel> panels) {
        this.panels = panels;
    }
}
