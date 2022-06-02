package com.example.movie_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_1.databinding.FragmentMovieBinding;
import com.example.movie_1.models.Movie;
import com.example.movie_1.models.YtsData;
import com.example.movie_1.repository.MovieService;

import java.util.List;

public class MovieFragment extends Fragment {
    // 안드로이드에서 만들어준 클래스
    private FragmentMovieBinding binding;

    // final - 불변성 위함, 값이 고정되기 때문에 성능에도 좋음
    private static final String TAG = MovieFragment.class.getName();

    // 프래그먼트가 메모리에 올라가는 순간
    // 여기서 통신 요청을 할 예정
    private MovieService movieService;

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 한 번만 생성되게
        movieService = MovieService.retrofit.create(MovieService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // findViewById 대체 (뷰 바인딩 활용)
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        // 리사이클러뷰 만들어주기


        return binding.getRoot();
    }

    // 통신해서 JSON 파싱해서 받은 다음에 매개변수로 데이터를 넘길 예정
    private void setupRecyclerView(List<Movie> movieList) {
        // 리사이클러뷰 준비물
        // 1. 어댑터
        // 2. 매니저
        // 3. xml 파일에 선언한 리사이클러뷰에 세팅

    }

}