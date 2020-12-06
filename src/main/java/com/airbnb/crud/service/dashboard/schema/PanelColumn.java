package com.airbnb.crud.service.dashboard.schema;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "panel_column")
@Data
public class PanelColumn {
    private String columnType;
    private String displayName;
    private String sqlColumnName;
    private String isVisible;
    private String columnOrder;

    @XmlAttribute(name="column_type")
    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    @XmlAttribute(name="display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @XmlAttribute(name="sql_column_name")
    public String getSqlColumnName() {
        return sqlColumnName;
    }

    public void setSqlColumnName(String sqlColumnName) {
        this.sqlColumnName = sqlColumnName;
    }

    @XmlAttribute(name="is_visible")
    public String getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }

    @XmlAttribute(name="column_order")
    public String getColumnOrder() {
        return columnOrder;
    }

    public void setColumnOrder(String columnOrder) {
        this.columnOrder = columnOrder;
    }
}
