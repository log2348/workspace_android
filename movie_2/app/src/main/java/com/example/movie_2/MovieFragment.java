package com.example.movie_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_2.adapter.MovieAdapter;
import com.example.movie_2.databinding.FragmentMovieBinding;
import com.example.movie_2.models.Movie;
import com.example.movie_2.repository.MovieService;

import java.util.ArrayList;
import java.util.List;

// 프래그먼트 -> 재사용성
public class MovieFragment extends Fragment {

    private FragmentMovieBinding binding;
    private static final String TAG = MovieFragment.class.getName();

    private MovieService movieService;
    private MovieAdapter movieAdapter;
    private List<Movie> list = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    // 프래그먼트 객체 반환
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
        binding = FragmentMovieBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    private void requestMoviesData(int requestPage) {


    }
}