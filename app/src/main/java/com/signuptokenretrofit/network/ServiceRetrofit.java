package com.signuptokenretrofit.network;

import com.signuptokenretrofit.model.DogResponsePojo;
import com.signuptokenretrofit.model.EmailPojo;
import com.signuptokenretrofit.model.SignupResponsePojo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceRetrofit {

    @Headers("Content-Type: application/json")
    @POST ("/signup")
    Call<SignupResponsePojo> getSignupResponse(@Body EmailPojo email);

    @GET("/feed")
    Call<DogResponsePojo> getDogResponse(@HeaderMap Map<String, String> headers, @Query("category") String category);
}
