package com.example.recyclerview;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerview.models.Food;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null) {
            Food food = (Food) getIntent().getSerializableExtra("obj");
            Log.d("TAG", food.toString());
        }
    }
}