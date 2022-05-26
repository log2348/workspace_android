package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerview.adapter.FoodAdapter;
import com.example.recyclerview.interfaces.OnFoodItemClickListener;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;

/*
    RecyclerView

    장점
    ListView 개선판
    ViewHolder 포함 (findViewById)
    유연하다
    준비물 LayoutManager, Adapter 클래스

 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FoodAdapter foodAdapter = new FoodAdapter(Food.getSampleData(), this, new OnFoodItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {
                // 여기가 호출 되어 진다.
                Log.d("TAG", "넘겨 받은 position : " + position);
                Intent intent = new Intent(getApplication(), DetailActivity.class); // getApplication() - this 대신
                intent.putExtra("obj", Food.getSampleData().get(position));
                startActivity(intent);
            }
        });

        // 통신 - JSON 받는 부분
        ArrayList<Food> listSample = Food.getSampleData();

        // 리사이클러뷰를 사용하기 위해서
        // 1. Adapter 클래스를 직접 생성해야 한다.
        // 2. LayoutManager 생성 해서 Adapter 클래스와 연결해야 한다.

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 그리드 형태
    }
}