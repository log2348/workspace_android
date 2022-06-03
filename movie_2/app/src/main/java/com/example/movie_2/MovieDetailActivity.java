package com.example.movie_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.movie_2.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movie;
    public static final String PARAM_NAME_1 = "move obj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }
}