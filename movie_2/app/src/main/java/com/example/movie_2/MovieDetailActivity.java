package com.example.movie_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movie_2.databinding.ActivityMovieDetailBinding;
import com.example.movie_2.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movie;
    private ActivityMovieDetailBinding binding;

    public static final String PARAM_NAME_1 = "move obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent() != null) {
            movie = (Movie) getIntent().getSerializableExtra(PARAM_NAME_1); // 직렬화된 객체 다운캐스팅 (다시 Object로 바꿔줌)
            initData();
        }
    }

    private void initData() {
        binding.titleTextView.setText(movie.getTitle());
        binding.releaseYearTextView.setText("Year of release : " + movie.getYear());
        binding.runTimeTextView.setText("Running Time : " + movie.getRuntime());

        Glide.with(this)
                .load(movie.getMediumCoverImage())
                .into(binding.posterImageView);
    }

}