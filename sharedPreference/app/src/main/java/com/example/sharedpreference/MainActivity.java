package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSave;
    private Button btnLoad;
    private Button btnDelete;
    private Button btnDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addEventListener();

        // SharedPreference
        // 어떤 파일에 데이터를 저장해두는 것, 데이터를 쓰고 싶을 때는 키, 벨류 값으로 접근하는 동작 만듦
        // 안드로이드 운영체제는 다른 앱으로 정보를 보낼 수 있음
        // 정보를 탈취할 수도 있기 때문에 MODE 설정 해두는 것
        SharedPreferences sp1 = getSharedPreferences("sp1", MODE_PRIVATE);
        /*
            MODE
            - MODE_PRIVATE : 생성한 어플리케이션에서만 사용 가능
            - MODE_WORLD_READABLE : 다른 앱에서 사용 가능하지만 읽을 수만 있음
            - MODE_WORLD_WRITEABLE : 다른 앱에서 사용 가능, 읽을 수 있고 기록도 가능
         */

        // 데이터를 입력해보기
        // 데이터를 넣기 위해 수정모드로 먼저 만들어야 한다
        SharedPreferences.Editor editor = sp1.edit();
        editor.putString("name", "홍길동"); // 여기까지 써도 저장 안됨
        // editor.commit(); // <- 저장 됨
        editor.apply();

        /*
            apply와 commit의 차이점

            apply() : 스레드를 블록시키지 않는다
                      비동기 방식
                      저장에 성공 여부 true, false 값을 주지 않는다
                      데이터를 저장 -> io 발생하기 때문에

            commit() : 스레드가 블록된다
                       동기 방식
                       commit은 저장을 성공하면 boolean 타입인 true 값을 반환한다
         */
    }

    private void initData() {
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
    }

    private void addEventListener() {
        btnSave.setOnClickListener(view -> {
            // name(String), age(int), isMarried(boolean) 데이터를 저장하는 기능을 만들어주세요

            // 1. sharedPreference 객체 불러 온다. (이름, 모드)
            // 2. 수정 모드로 만들어줘야 한다.
            // 3. 저장할 데이터를 입력한다.
            // 4. 비동기 방식으로 데이터를 완전히 저장한다.

            SharedPreferences sp1 = getSharedPreferences("sp1", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp1.edit();
            editor.putString("name", "이순신");
            editor.putInt("age", 20);
            editor.putBoolean("isMarried", true);
            editor.apply();
        });

        // 값을 꺼내오는 것
        btnLoad.setOnClickListener(view -> {
            // 데이터 읽어보기
            SharedPreferences sp1 = getSharedPreferences("sp1", MODE_PRIVATE);
            String name = sp1.getString("name", "");
            int age = sp1.getInt("age", 0);
            boolean isMarried = sp1.getBoolean("isMarried", false);

            Toast.makeText(this, "age : " + age, Toast.LENGTH_LONG).show();
            Log.d("TAG", "name : " + name);
            Log.d("TAG", "age : " + age);
            Log.d("TAG", "isMarried : " + isMarried);
        });

        btnDelete.setOnClickListener(view -> {
            // 메서드 체이닝 방식으로 코드 작성해보기
            // age <- 삭제
            getShared("sp1").edit().remove("age").apply();
            // 잘 삭제가 되었는지 확인하기

            // 코드 상으로 버튼을 눌렀다 명령하기
            btnLoad.callOnClick();
        });

        btnDeleteAll.setOnClickListener(view -> {
            getShared("sp1").edit().clear().apply();

            // 코드 상으로 버튼 누르기
            btnLoad.callOnClick();
        });

    }

    private SharedPreferences getShared(String name) {
        return getSharedPreferences(name, MODE_PRIVATE);
    }
}