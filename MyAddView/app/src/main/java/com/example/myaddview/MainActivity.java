package com.example.myaddview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fruit> sampleData = Fruit.getFruits();

        // addView 방식
        // 뷰를 위치시킬 컨테이너 가져오기
        LinearLayout container = findViewById(R.id.fruitContainer);

        // Inflater 생성
        LayoutInflater inflater = LayoutInflater.from(this); // new LayoutInflater() 와 같다

        // 람다식을 활용한 for문
        sampleData.forEach(fruit -> {
            // Inflater 객체를 이용해서 xml 파일을 메모리에 올리고 어디에 올릴지 설정
            View itemView = inflater.inflate(R.layout.item_food, container, false);

            ImageView fruitImageView = itemView.findViewById(R.id.fruitImageView);
            TextView fruitNameTextView = itemView.findViewById(R.id.fruitNameTextView);
            TextView fruitPriceTextView = itemView.findViewById(R.id.fruitPriceTextView);
            TextView fruitCountTextView = itemView.findViewById(R.id.fruitCountTextView);
            fruitNameTextView.setText(fruit.name);
            fruitPriceTextView.setText(fruit.price);
            fruitCountTextView.setText(fruit.count);

            // 이미지 셋팅
            Glide.with(this)
                    .load(fruit.imageUrl)
                    .centerCrop()
                    .into(fruitImageView);

            container.addView(itemView);
        });
    }
}