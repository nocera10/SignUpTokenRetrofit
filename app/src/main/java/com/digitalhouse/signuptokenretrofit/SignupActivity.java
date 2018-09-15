package com.digitalhouse.signuptokenretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.digitalhouse.signuptokenretrofit.models.SignupResponsePojo;
import com.digitalhouse.signuptokenretrofit.network.RetrofitClientInstance;
import com.digitalhouse.signuptokenretrofit.network.ServiceRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    EditText signupEmail;
    EditText signupPassword;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);

    }

    public void signUpAction() {

        progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        ServiceRetrofit service = RetrofitClientInstance.getRetrofitInstance().create(ServiceRetrofit.class);

        Call<SignupResponsePojo> call = service.getSignupResponse(signupEmail.getText().toString());

        call.enqueue(new Callback<SignupResponsePojo>() {

            @Override
            public void onResponse(Call<SignupResponsePojo> call, Response<SignupResponsePojo> response) {
                progressDialog.dismiss();
                String token = response.body().getUser().getToken();
                Toast.makeText(SignupActivity.this, "Fucking right indian boy", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignupResponsePojo> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(SignupActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
