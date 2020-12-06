package com.airbnb.crud.service.dashboard.schema;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class DashboardPanelAdapter extends XmlAdapter<DashboardPanels, Map<String, DashboardPanel>> {
    @Override
    public Map<String, DashboardPanel> unmarshal(DashboardPanels panels) throws Exception {
        Map<String, DashboardPanel> map = new LinkedHashMap<String, DashboardPanel>();
        for (DashboardPanel panel : panels.getPanels()) {
            map.put(panel.getId(), panel);
        }
        return map;
    }

    @Override
    public DashboardPanels marshal(Map<String, DashboardPanel> map) throws Exception {
        DashboardPanels panels = new DashboardPanels();
        if(map!=null) {
            panels.setPanels(new LinkedList<DashboardPanel>(map.values()));
        }
        return panels;
    }
}
