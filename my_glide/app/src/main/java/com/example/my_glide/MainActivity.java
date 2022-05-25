package com.example.my_glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView1 = findViewById(R.id.gImageView1);
        imageView2 = findViewById(R.id.gImageView2);
        imageView3 = findViewById(R.id.gImageView3);
        imageView4 = findViewById(R.id.gImageView4);
        imageView5 = findViewById(R.id.gImageView5);
        imageView6 = findViewById(R.id.gImageView6);

        // 6개 이미지에 인물 사진 그리기
        Glide
                .with(this)
                .load("https://cdn.pixabay.com/photo/2016/03/23/04/01/woman-1274056__340.jpg")
                .circleCrop()
                .into(imageView1);

        Glide
                .with(this)
                .load("https://cdn.pixabay.com/photo/2017/11/06/13/45/cap-2923682__340.jpg")
                .circleCrop()
                .into(imageView2);

        Glide
                .with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/07/07/48/couple-2601156__340.jpg")
                .circleCrop()
                .into(imageView3);

        Glide
                .with(this)
                .load("https://cdn.pixabay.com/photo/2017/02/15/12/12/cat-2068462__340.jpg")
                .circleCrop()
                .into(imageView4);

        Glide
                .with(this)
                .load("https://cdn.pixabay.com/photo/2017/04/05/01/15/ocean-2203720__340.jpg")
                .circleCrop()
                .into(imageView5);

        // "https://picsum.photos/200/300?random=1" random에 숫자 넣으면 랜덤으로 이미지 반환
        Glide
                .with(this)
                .load("@drawble/temp")
                .into(imageView6);

        // 프로젝트에 있는 이미지들을 circleCrop() 처리 한다면 사용이 안됨 (CircleImageView 사용해서 처리하고 붙여야함)

        // glide 사용하면 네트워크 통신 이미지든 로컬이미지든 편하게 사용할 수 있다.
        // 피카소를 사용하기도 하는데 글라이드가 더 기능이 많다.

    }
}
