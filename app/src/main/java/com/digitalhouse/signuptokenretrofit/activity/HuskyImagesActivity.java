package com.digitalhouse.signuptokenretrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.digitalhouse.signuptokenretrofit.R;
import com.digitalhouse.signuptokenretrofit.adapter.DogImageListAdapter;
import com.digitalhouse.signuptokenretrofit.model.DogResponsePojo;
import com.digitalhouse.signuptokenretrofit.network.RetrofitClientInstance;
import com.digitalhouse.signuptokenretrofit.network.ServiceRetrofit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HuskyImagesActivity extends AppCompatActivity {

    private DogImageListAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_husky_images);

        ServiceRetrofit service = RetrofitClientInstance.getRetrofitInstance().create(ServiceRetrofit.class);
        String token = SignupActivity.getTokenFromPreference(HuskyImagesActivity.this,"TOKEN");
        Log.i("GETTOKEN2", token);

        final String CONTENT_TYPE = "application/json";

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", token);
        map.put("Content-Type", CONTENT_TYPE);

        Call<DogResponsePojo> call = service.getDogResponse(map);
        call.enqueue(new Callback<DogResponsePojo>() {
            @Override
            public void onResponse(Call<DogResponsePojo> call, Response<DogResponsePojo> response) {
                generateUrlImageList(response.body().getList());
            }

            @Override
            public void onFailure(Call<DogResponsePojo> call, Throwable t) {
                Toast.makeText(HuskyImagesActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void generateUrlImageList(List<String> urlImageList) {

        recyclerView = findViewById(R.id.dog_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HuskyImagesActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new DogImageListAdapter(urlImageList);
        recyclerView.setAdapter(adapter);
    }
}
