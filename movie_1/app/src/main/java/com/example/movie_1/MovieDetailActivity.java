package com.example.movie_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.movie_1.databinding.ActivityMovieDetailBinding;
import com.example.movie_1.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    // 1. 데이터 전달 받아서 화면을 구성
    // 2. 여기서 통신 요청해서 화면을 구성
    private Movie movie;
    public static final String PARAM_NAME_1 = "movie obj";
    private ActivityMovieDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getIntent() != null) {
            movie = (Movie) getIntent().getSerializableExtra(PARAM_NAME_1);
            initData();
            addEventListener();
        }
    }

    private void initData() {
        binding.titleTextView.setText(movie.getTitle());
        binding.yearTextView.setText("제작 년도 : " + movie.getYear());
        binding.runtimeTextView.setText("상영 시간 : " + movie.getRuntime() + "분");

        Glide.with(this)
                .load(movie.getMediumCoverImage())
                .into(binding.moviesPoster);

        Glide.with(this)
                .load(movie.getBackgroundImage())
                .into(binding.backgroundImageView);
    }

    private void addEventListener() {


    }
}