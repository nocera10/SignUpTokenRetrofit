package com.digitalhouse.signuptokenretrofit.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.digitalhouse.signuptokenretrofit.R;

public class DogBreedActivity extends AppCompatActivity {

    Button huskyImagesButton;
    Button houndImagesButton;
    Button pugImagesButton;
    Button labradorImagesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_breed);

        huskyImagesButton = findViewById(R.id.husky_images_button);
        houndImagesButton = findViewById(R.id.hound_images_button);
        pugImagesButton = findViewById(R.id.pug_images_button);
        labradorImagesButton = findViewById(R.id.labrador_images_button);
    }

    public void huskyButtonAction(View v) {
        Intent intent = new Intent(DogBreedActivity.this, HuskyImagesActivity.class);
        startActivity(intent);
    }
}
