package com.example.myretrofit.repository.models;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

// 비즈니스 로직
// todo 데이터를 들고 오는 것
// post 데이터를 들고 오는 것
// user 데이터를 들고 오는 것

public interface RetrofitService {

    // https://jsonplaceholder.typicode.com/(baseUrl) + todos
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

}
