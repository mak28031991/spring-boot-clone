package com.airbnb.crud.client;

import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Configuration
public class DemandClientConfig {
    @Value("$demand.service.baseURL")
    private String DEMAND_SERVICE_URL;

    // Create a Bean for demand Service client and add it to SpringContext.
    @Bean
    public DemandServiceClient demandServiceClient() {
        return createHttpClient().create(DemandServiceClient.class);
    }

    // Create Retrofit instance of DemandService
    private Retrofit createHttpClient() {
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
        return new Retrofit.Builder()
                .baseUrl(DEMAND_SERVICE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient)
                .build();
    }
}
