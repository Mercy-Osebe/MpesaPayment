package com.example.mpesapayment.networking;

import com.example.mpesapayment.pojos.TokenResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface SafaricomService {
    @Headers("Authorization: Basic YUhqbFJmUXZoMGZzekVzU3VyTkk1bEUzdWJUNGZXZHI6WEc3czZxT0MyS0tVQndxQg==")
    @GET("oauth/v1/generate?grant_type=client_credentials")
    Call<TokenResponse> getAccess_token();
}
