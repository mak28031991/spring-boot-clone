package com.airbnb.crud.service.dashboard.schema;

import org.springframework.core.io.ClassPathResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;

public class DashboardProvider {
    private static Dashboard dashboard;
    private static final DashboardProvider instance = new DashboardProvider();
    private DashboardProvider(){
        try {
            initializeDashboard();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void initializeDashboard() throws IOException {
        String dashboardXmlFile = "dashboard.xml";
        InputStream in = new ClassPathResource(dashboardXmlFile).getInputStream();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Dashboard.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            dashboard = (Dashboard) jaxbUnMarshaller.unmarshal(in);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

    public static DashboardProvider getDashboardProvider(){
        return instance;
    }

    public Dashboard getDashboard(){
        return dashboard;
    }
}
