package com.airbnb.crud.service.demand.impl;

import com.airbnb.crud.client.DemandServiceClient;
import com.airbnb.crud.client.model.DemandData;
import com.airbnb.crud.client.model.DemandResponse;
import com.airbnb.crud.service.demand.IDemandService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
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

    @Value("$demand.service.baseURL")
    private String DEMAND_SERVICE_URL;
    private DemandServiceClient client;

    @PostConstruct
    public void initialize(){
        int CONNECT_TIMEOUT = 5000;
        int READ_TIMEOUT = 5000;
        int POOL_SIZE = 50;
        ConnectionPool pool = new ConnectionPool(POOL_SIZE, 5, TimeUnit.MINUTES);// adjust according to ur use case
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("Content-Type","application/json")// add as many headers u want
                                .addHeader("User-Agent","Airbnb-Service")// add as many headers u want
                                .build();
                        return chain.proceed(request);
                    }
                })
                .connectionPool(pool)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DEMAND_SERVICE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient)
                .build();
        this.client = retrofit.create(DemandServiceClient.class);
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
