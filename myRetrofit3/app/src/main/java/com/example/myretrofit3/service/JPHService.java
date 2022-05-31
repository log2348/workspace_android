package com.example.myretrofit3.service;

import com.example.myretrofit3.models.request.ReqPostDto;
import com.example.myretrofit3.models.response.ResponsePostDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

// https://jsonplaceholder.typicode.com/
public interface JPHService {

    // 레트로핏 초기화
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // 서비스로직 설계

    // https://jsonplaceholder.typicode.com/posts/{id}
    @GET("posts/{id}")
    Call<ResponsePostDto> post(@Path("id") int id);

    @GET("posts")
    Call<List<ResponsePostDto>> postList();

    // HTTP 메시지 body 부분에 데이터를 넣어서 서버를 전달한다. MIME Type : json
    // 우리의 데이터가 잘 전달되었다면 서버속에서는 응답 값을 보내준다.
    // 값을 보낼 때 어떻게 데이터를 보낼지 설계 해야 한다.
    @POST("posts")
    Call<ResponsePostDto> createPost(@Body ReqPostDto reqPostDto);

    @PUT("posts/{postId}")
    Call<ResponsePostDto> updatePost(@Path("postId") int postId,
                                     @Body ReqPostDto reqPostDto);

    // 서버측에서 HTTP 메서드 체크한다 -> REST API이기 때문에
    @DELETE("post/{postId}")
    Call<Void> deletePost(@Path("postId") int postId);

    /*
    @FormUrlEncoded
    @GET("/posts")
    Call<List<ResponsePostDto>> searchByUserId(@Field("userId") int userId);
     */
}
