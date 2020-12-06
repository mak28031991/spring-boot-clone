package com.airbnb.crud.service.dashboard.schema;


import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "panel_headers")
@Data
public class PanelHeaders {

    List<PanelColumn> headers;

    @XmlElement(name="panel_column")
    public List<PanelColumn> getHeaders() {
        return headers;
    }

    public void setHeaders(List<PanelColumn> headers) {
        this.headers = headers;
    }
}

