package com.example.sif.mvptest.Controllers.Activities.Testing;

import com.example.sif.mvptest.Model.DataModels.StackApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("nzin01312019187360.json")
    Call<String> getMatches();

    @GET("answers")
    Call<StackApiResponse> getAnswers(@Query("page") int page, @Query("pagesize") int pagesize, @Query("site") String site);
}