package com.example.callbacktest.repository;

import com.example.callbacktest.models.YtsData;
import com.example.callbacktest.utils.Define;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Define.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("list_movies.json")
    Call<YtsData> getMovieInfo(
      @Query("sort_by") String sort_by,
      @Query("limit") int limit,
      @Query("page") int page
    );

}
