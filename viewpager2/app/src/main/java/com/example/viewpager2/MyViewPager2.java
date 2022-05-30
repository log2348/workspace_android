package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.viewpager2.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class MyViewPager2 extends AppCompatActivity {

    private ViewPager2 imageSlider;
    private ArrayList<String> images = new ArrayList<>();
    private LinearLayout indicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_pager2);

        images.add("https://cdn.pixabay.com/photo/2019/11/23/03/08/valley-4646114_960_720.jpg");
        images.add("https://cdn.pixabay.com/photo/2019/04/08/16/49/blooming-4112348_960_720.jpg");
        images.add("https://cdn.pixabay.com/photo/2021/07/19/22/07/mountains-6479150_960_720.jpg");
        images.add("https://cdn.pixabay.com/photo/2019/06/24/16/43/mountain-4296464_960_720.jpg");
        images.add("https://cdn.pixabay.com/photo/2016/10/25/11/37/snow-1768544__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2019/07/21/18/30/mountain-4353332_960_720.jpg");

        indicatorsContainer = findViewById(R.id.indicatorsContainer);
        imageSlider = findViewById(R.id.myViewPager2); // 뷰페이저 객체
        
        // 현재 보여지는 화면에서 몇 개의 페이지를 유지할지 설정
        imageSlider.setOffscreenPageLimit(2);

        // 뷰페이저와 어댑터 연결
        // 어댑터 생성시 이미지에 대한 정보를 넘겨서 뷰 컴포넌트에 이미지를 올린다
        imageSlider.setAdapter(new ViewPagerAdapter(this, images));

        imageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            // 페이지 선택될때 호출
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });
        setupIndicators(images.size());
    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));

            indicators[i].setLayoutParams(params);
            indicatorsContainer.addView(indicators[i]);
        }
    }

    private void setCurrentIndicator(int position) {
        int childCount = indicatorsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) indicatorsContainer.getChildAt(i);
            if (i == position) { // 선택되었을 때
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_inactive));
            }
        }
    }
}