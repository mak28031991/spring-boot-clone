package com.airbnb.crud.service.demand.impl;

import com.airbnb.crud.client.DemandServiceClient;
import com.airbnb.crud.client.model.DemandData;
import com.airbnb.crud.client.model.DemandResponse;
import com.airbnb.crud.service.demand.IDemandService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class DemandServiceImpl implements IDemandService {

    private final DemandServiceClient client;

    @Autowired
    public DemandServiceImpl(DemandServiceClient client) {
        this.client = client;
    }

    @Override
    public DemandData getDemandForCustomer(Long customerId) throws IOException {
        Call<DemandResponse> retrofitCall = client.getDemandForCustomer(customerId);
        Response<DemandResponse> response = retrofitCall.execute();
        if(!response.isSuccessful()){
            //log some error or throw it
            log.error("some thing went wrong in API call");
        }
        return response.body().getData();
    }
}
