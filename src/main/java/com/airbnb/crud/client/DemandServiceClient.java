package com.airbnb.crud.client;

import com.airbnb.crud.client.model.DemandResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DemandServiceClient {

    @GET("changes/customer_id")
    Call<DemandResponse> getDemandForCustomer(@Path("customer_id") Long customerId);
}
