package com.digitalhouse.signuptokenretrofit.network;

import android.provider.ContactsContract;

import com.digitalhouse.signuptokenretrofit.model.DogResponsePojo;
import com.digitalhouse.signuptokenretrofit.model.SignupResponsePojo;
import com.digitalhouse.signuptokenretrofit.model.EmailPojo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServiceRetrofit {

    @Headers("Content-Type: application/json")
    @POST ("/signup")
    Call<SignupResponsePojo> getSignupResponse(@Body EmailPojo email);

    @GET("/feed")
    Call<DogResponsePojo> getDogResponse(@HeaderMap Map<String, String> headers);

    @Headers("Content-Type: application/json")
    @GET("/feed/{category}")
    Call<DogResponsePojo> getDogResponse(@Header("Authorization") String token, @Path("category") String category);
}
