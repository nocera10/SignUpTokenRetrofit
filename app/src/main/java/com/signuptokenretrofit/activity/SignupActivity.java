package com.signuptokenretrofit.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.signuptokenretrofit.R;
import com.signuptokenretrofit.model.EmailPojo;
import com.signuptokenretrofit.model.SignupResponsePojo;
import com.signuptokenretrofit.network.RetrofitClientInstance;
import com.signuptokenretrofit.network.ServiceRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    EditText signupEmail;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupEmail = findViewById(R.id.signup_email);
        signupButton = findViewById(R.id.signup_button);

    }

    public void signupAction(View v) {

        progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        ServiceRetrofit service = RetrofitClientInstance.getRetrofitInstance().create(ServiceRetrofit.class);

        EmailPojo email = new EmailPojo(signupEmail.getText().toString());

        Call<SignupResponsePojo> call = service.getSignupResponse(email);

        call.enqueue(new Callback<SignupResponsePojo>() {

            @Override
            public void onResponse(Call<SignupResponsePojo> call, Response<SignupResponsePojo> response) {
                progressDialog.dismiss();
                String token = response.body().getUser().getToken();
                SignupActivity.setTokenToPreference(SignupActivity.this, token);
                Log.i("GETTOKEN1", token);

                // This intent below just changes activity. I am not using bundle to send the token because the SharedPreferences above
                Intent intent = new Intent(SignupActivity.this, DogBreedActivity.class);
                startActivity(intent);

                Toast.makeText(SignupActivity.this, "Sign Up successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignupResponsePojo> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(SignupActivity.this, "Invalid email. Please provide a valid one", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void setTokenToPreference(Context context, String value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("TOKEN", value).apply();
    }

    public static String getTokenFromPreference(Context context, String key) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("TOKEN", "No String found in preferences");
    }
}
