package com.example.sif.mvptest;

import com.google.android.gms.common.api.Api;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;


    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}