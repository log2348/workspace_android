package com.example.movie_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_2.adapter.MovieAdapter;
import com.example.movie_2.databinding.FragmentMovieBinding;
import com.example.movie_2.interfaces.OnMovieItemViewClicked;
import com.example.movie_2.models.Movie;
import com.example.movie_2.models.YtsData;
import com.example.movie_2.repository.MovieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// 프래그먼트 -> 재사용성
public class MovieFragment extends Fragment implements OnMovieItemViewClicked {

    private FragmentMovieBinding binding;
    private static final String TAG = MovieFragment.class.getName();

    private MovieService movieService;
    private MovieAdapter movieAdapter;
    private List<Movie> list = new ArrayList<>();

    // 싱글톤 패턴
    private static MovieFragment movieFragment;

    private int currentPageNumber = 1;

    private boolean preventDuplicateScrollEvent = true;

    private boolean isFirstLoading = true;

    public MovieFragment() {
        // Required empty public constructor
    }

    // 싱글톤 패턴
    public static MovieFragment getInstance() {
        if (movieFragment == null) {
            movieFragment = new MovieFragment();
        }
        return movieFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMovieBinding.inflate(inflater, container, false);

        // 리사이클러뷰 만들기
        setupRecyclerView(list);


        return binding.getRoot();
    }

    private void requestMoviesData(int requestPage) {

        int ITEM_LIMIT = 10;

        movieService.getMovieInfo("rating", ITEM_LIMIT, requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            List<Movie> list = response.body().getData().getMovies();

                            movieAdapter.addItem(list);
                            currentPageNumber++;

                            preventDuplicateScrollEvent = true;

                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {

                    }
                });

    }

    private void setupRecyclerView(List<Movie> movieList) {
        // 리사이클러뷰 준비물
        // 1. 어댑터
        movieAdapter = new MovieAdapter();
        movieAdapter.setOnMovieItemViewClicked(this);
        movieAdapter.initItemList(movieList);

        // 2. 매니저
        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        // 3. xml 파일에 리사이클러뷰 컴포넌트 세팅
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        // 이벤트 리스너
        binding.recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {

            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (preventDuplicateScrollEvent) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) binding.recyclerView.getLayoutManager();
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();

                    int itemTotalCount = binding.recyclerView.getAdapter().getItemCount() - 1;

                    if(lastVisibleItemPosition == itemTotalCount) {
                        if (currentPageNumber != 1) {

                            requestMoviesData(currentPageNumber);
                        }
                    }
                }
            }
        });
    }

    @Override
    public void selectedItem(Movie movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        // Movie 클래스 직렬화
        intent.putExtra(MovieDetailActivity.PARAM_NAME_1, movie);
        startActivity(intent);
    }
}