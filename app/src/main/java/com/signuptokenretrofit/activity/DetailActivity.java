package com.signuptokenretrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.signuptokenretrofit.R;

public class DetailActivity extends AppCompatActivity {

    ImageView dogDetailPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dogDetailPicture = findViewById(R.id.image_view_detail);

        String urlImage = getIntent().getExtras().getString("husky_picture");

        Glide.with(this)
                .load(urlImage)
                .into(dogDetailPicture);
    }
}
