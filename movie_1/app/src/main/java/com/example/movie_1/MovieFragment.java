package com.example.movie_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_1.databinding.FragmentMovieBinding;

public class MovieFragment extends Fragment {

    // 안드로이드에서 만들어준 클래스
    private FragmentMovieBinding binding;
    // final - 불변성 위함, 값이 고정되기 때문에 성능에도 좋음
    private static final String TAG = MovieFragment.class.getName();

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // findViewById 대체 (뷰 바인딩 활용)
        // inflater.inflate(R.layout.fragment_movie, container, false);

        binding = FragmentMovieBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}