package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myhttp.models.Post;
import com.example.myhttp.models.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button connectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectBtn = findViewById(R.id.connectBtn);
        addEventListener();

        // 안드로이드는 UI 쓰레드가, 메인 쓰레드가 화면을 그리는 데 집중하고 있음
        // -> 네트워크 통신을 하기 위해서는 무조건 쓰레드를 만들어 주어야 함
        // -> 쓰레드 사용하지 않을시 크래쉬 남 (NetworkOnMainThreadException 발생)
        new Thread(() -> {
            httpGetTest();
        }).start();
    }

    private void httpGetTest() {
        String urlString = "https://jsonplaceholder.typicode.com/todos";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 참고
            // connection.setRequestProperty("Content-Type", "application/json; charset-UTF-8");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // 통신성공
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(),
                        "UTF-8"
                ));
                // 1. 한 라인(한 줄)씩 읽기
                /*
                String line = null;
                StringBuffer sb = new StringBuffer();

                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                Log.d("TAG", sb.toString());
                */

                // gson 쓰기 전에 -> Dto 만들어야 함

                // 문자열 -> 하나의 오브젝트로 변환하는 방법
                // Todo todo1 = new Gson().fromJson(reader, Todo.class);
                // Log.d("TAG", todo1.title);

                // 문자열 -> 배열 타입으로 변환하는 방법
                // Todo[] todos = new Gson().fromJson(reader, Todo[].class);
                // Log.d("TAG", todos.toString());

                // 문자열 -> ArrayList 타입으로 변환하는 방법
                Type todoListType = new TypeToken<ArrayList<Todo>>() {
                }.getType();
                ArrayList<Todo> todoList = new Gson().fromJson(reader, todoListType);

                for (Todo t : todoList) {
                    Log.d("TAG", "userId : " + t.userId);
                    Log.d("TAG", "title : " + t.title);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addEventListener() {
        connectBtn.setOnClickListener(view -> {
            String urlString = "https://jsonplaceholder.typicode.com/posts";
            new Thread(() -> {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                                connection.getInputStream(), "UTF-8"
                        ));

                        Type postListType = new TypeToken<ArrayList<Post>>() {
                        }.getType();
                        ArrayList<Post> postList = new Gson().fromJson(bufferedReader, postListType);

                        for (Post p : postList) {
                            Log.d("TAG", "title : " + p.title);
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();

        });
    }
}