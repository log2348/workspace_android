package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.viewpager2.adapter.ImageSliderAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 sliderImageViewPager;
    private ArrayList<String> images = new ArrayList<>();
    private LinearLayout layoutIndicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 샘플 데이터
        images.add("https://cdn.pixabay.com/photo/2013/11/28/10/36/road-220058__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2017/05/20/20/22/clouds-2329680__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2016/06/07/16/12/sky-1441936__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2015/11/16/22/39/balloons-1046658__340.jpg");

        layoutIndicatorsContainer = findViewById(R.id.layoutIndicators);
        sliderImageViewPager = findViewById(R.id.sliderViewPager2);
        sliderImageViewPager.setOffscreenPageLimit(2);
        sliderImageViewPager.setAdapter(new ImageSliderAdapter(this, images));
        sliderImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // 페이지 선택될때마다 콜백 메서드 호출
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });
        setupIndicators(images.size());

    } // end of OnCreate

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        /*
            LayoutParams
            뷰가 어떻게 배치 될지 정의하는 속성
            xml 파일에서 layout_ 붙는 속성들을 자바에서 처리하는 것.
            LayoutParams 객체를 통해서 다룰 수 있다.
         */
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));
            // imageView OBJ
            indicators[i].setLayoutParams(params);
            layoutIndicatorsContainer.addView(indicators[i]);
        }
    } // end of setupIndicators

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicatorsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicatorsContainer.getChildAt(i);
            if(i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_active));
            } else { // 선택되지 않으면
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_inactive));
            }
        }
    }
}