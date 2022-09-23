package com.example.mpesapayment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mpesapayment.networking.SafaricomService;
import com.example.mpesapayment.pojos.TokenResponse;

import java.nio.charset.StandardCharsets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText phoneNo;
    Button send;
    TextView view;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNo=findViewById(R.id.editTextPhoneNumber);
        send=findViewById(R.id.btnSendMoney);
        view=findViewById(R.id.textViewPhoneNumber);
        progressBar=findViewById(R.id.progressBar);
        String phone=view.getText().toString().trim();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAccessToken();
            }
        });
    }

    //get the access-token
    private void getAccessToken() {
        progressBar.setVisibility(View.VISIBLE);
//        String keyCombined = SafaricomConfigurations.CONSUMER_KEY + ":" + SafaricomConfigurations.CONSUMER_SECRET;
//        String credentials = Base64.encodeToString(keyCombined.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT);
//        System.out.println(credentials);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sandbox.safaricom.co.ke/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SafaricomService safaricomService = retrofit.create(SafaricomService.class);

        Call<TokenResponse> fetchAccessToken = safaricomService.getAccess_token();
        fetchAccessToken.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(@NonNull Call<TokenResponse> call, @NonNull Response<TokenResponse> response) {
                progressBar.setVisibility(View.INVISIBLE);
                TokenResponse tokenResponse = response.body();
                assert tokenResponse != null;
                String token = tokenResponse.getAccess_token();
                Log.d(TAG, "token:" + token);

            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.d(TAG, t.getMessage());

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void stkPushNotification(){
        //to be implemented.
    }


}