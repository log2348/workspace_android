package com.example.movie_1.repository;

import com.example.movie_1.models.YtsData;
import com.example.movie_1.utils.Define;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    // public static final <-- 생략되어 있다
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Define.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // 서비스 로직
    @GET("list_movies.json")
    Call<YtsData> repoContributors(
            @Query("sort_by") String sort_by,
            @Query("limit") int limit,
            @Query("page") int page
    );
}
