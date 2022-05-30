package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myretrofit.repository.models.RetrofitService;
import com.example.myretrofit.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// 모델 분리
// Service - 비즈니스 로직 처리하는 부분 분리
public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    RetrofitService service;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.temp);

        // retrofit 객체 초기화
        // 빌더패턴 -> 매개변수 순서 상관없이 사용할 수 있다
        // baseUrl 사용시 반드시 마지막에 슬러쉬(/) 해주어야 한다
        // GsonConverterFactory.create() 사용하면 gson 라이브러리 써서 파싱하는 과정 한번에 처리
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 초기화된 레트로 핏 object와 비즈니스 로직인 인터페이스 연결
        service = retrofit.create(RetrofitService.class);

        // enqueue() - 비동기 네트워크 통신할거야
        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d("TAG",  "--------> " + response.isSuccessful());
                Log.d("TAG",  "--------> " + response.message());
                if(response.isSuccessful()) {

                    // Gson (타입 변환 코드) X 쓰레드 X (레트로핏 라이브러리의 효용)
                    Todo todo = response.body().get(0);
                    Log.d("TAG", "userId : " + todo.userId);
                    textView.setText(todo.completed + "");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                Log.d("TAG", "실패 : " + t.getMessage());
            }
        });
    }
}