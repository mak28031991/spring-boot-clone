package com.airbnb.crud.service.demand;

import com.airbnb.crud.client.model.DemandData;

import java.io.IOException;

public interface IDemandService {
    DemandData getDemandForCustomer(Long customerId) throws IOException;
}
