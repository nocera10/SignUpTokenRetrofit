package com.digitalhouse.signuptokenretrofit.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api-iddog.idwall.co";

    public static Retrofit getRetrofitInstance() {

        // RECEITA DE BOLO

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // Set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // Add your other interceptors ...

        // Add logging as last interceptor
        httpClient.addInterceptor(logging); // <-- this is the important line

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
