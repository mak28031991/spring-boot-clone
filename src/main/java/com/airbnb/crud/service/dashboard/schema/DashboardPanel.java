package com.airbnb.crud.service.dashboard.schema;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
public class DashboardPanel {
    private String title;
    private String panelType;
    private String id;
    private PanelHeaders panelHeaders;
    private String sqlQuery;

    @XmlAttribute(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlAttribute(name="panel_type")
    public String getPanelType() {
        return panelType;
    }

    public void setPanelType(String panelType) {
        this.panelType = panelType;
    }

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @XmlElement(name="panel_headers")
    public PanelHeaders getPanelHeaders() {
        return panelHeaders;
    }

    public void setPanelHeaders(PanelHeaders panelHeaders) {
        this.panelHeaders = panelHeaders;
    }

    @XmlElement(name="sql_query")
    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }
}
