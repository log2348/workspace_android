package com.example.callbacktest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.callbacktest.adpter.MovieAdapter;
import com.example.callbacktest.databinding.FragmentCardViewBinding;
import com.example.callbacktest.models.Movie;
import com.example.callbacktest.models.YtsData;
import com.example.callbacktest.repository.MovieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardViewFragment extends Fragment {

    private static CardViewFragment cardViewFragment;
    private MovieService movieService;
    private MovieAdapter movieAdapter;
    private FragmentCardViewBinding binding;

    private List<Movie> list = new ArrayList<>();

    private int currentPageNumber = 1;

    // 첫 화면에만 progressBar 뜨도록
    private boolean isFirstLoading = true;

    private boolean preventDuplicateScrollEvent = true;


    public CardViewFragment() {
        // Required empty public constructor
    }

    // 싱글톤 패턴
    public static CardViewFragment getInstance() {
        if (cardViewFragment == null) {
            cardViewFragment = new CardViewFragment();
        }
        return cardViewFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService = MovieService.retrofit.create(MovieService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCardViewBinding.inflate(inflater, container, false);

        setRecyclerView(list);

        if (isFirstLoading) {
            requestMovieData(currentPageNumber);
        } else {
            setVisibleProgressBar(View.GONE);
        }

        return binding.getRoot();
    }

    private void requestMovieData(int requestPage) {

        movieService.getMovieInfo("rating", 10, requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            List<Movie> list = response.body().getData().getMovies();

                            movieAdapter.addItem(list);
                            currentPageNumber++;

                            preventDuplicateScrollEvent = true;
                            isFirstLoading = false;
                            setVisibleProgressBar(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        Toast.makeText(binding.getRoot().getContext(), "네트워크 연결이 불안정합니다.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void setRecyclerView(List<Movie> movieList) {
        // 1. 어댑터 세팅
        movieAdapter = new MovieAdapter();
        movieAdapter.initItemList(movieList);

        // 2. 레이아웃 매니저
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);

        // 3. 정보 계속 갱신되도록 이벤트 리스너
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(manager);
        //recyclerView.setHasFixedSize(true);

        // 스크롤시 데이터 갱신 이벤트
        binding.recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {

            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // 한번만 실행하기 위해 (중복 x)
                if (preventDuplicateScrollEvent) {
                    GridLayoutManager layoutManager = (GridLayoutManager) binding.recyclerView.getLayoutManager();
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();

                    int itemTotalCount = binding.recyclerView.getAdapter().getItemCount() - 1;

                    if (lastVisibleItemPosition == itemTotalCount) {
                        if (currentPageNumber != 1) {
                            preventDuplicateScrollEvent = false;
                            requestMovieData(currentPageNumber);
                        }
                    }

                }
            }
        });
    }

    private void setVisibleProgressBar(int visible) {
        binding.linearProgressIndicator.setVisibility(visible);
    }

}