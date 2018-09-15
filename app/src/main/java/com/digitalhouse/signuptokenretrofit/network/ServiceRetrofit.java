package com.digitalhouse.signuptokenretrofit.network;

import com.digitalhouse.signuptokenretrofit.models.SignupResponsePojo;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceRetrofit {

    @Headers("Content-Type: application/json")
    @POST ("/signup")
    Call<SignupResponsePojo> getSignupResponse(@Header("email") String email);
}
