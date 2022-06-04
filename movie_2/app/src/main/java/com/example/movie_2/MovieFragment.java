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
import android.widget.Toast;

import com.example.movie_2.adapter.MovieAdapter;
import com.example.movie_2.databinding.FragmentMovieBinding;
import com.example.movie_2.interfaces.OnMovieItemViewClicked;
import com.example.movie_2.interfaces.OnTopAppBarTitleChanged;
import com.example.movie_2.models.Movie;
import com.example.movie_2.models.YtsData;
import com.example.movie_2.repository.MovieService;
import com.example.movie_2.utils.Define;

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

    private OnTopAppBarTitleChanged onTopAppBarTitleChanged; // 이대로 두면 NullPointerException 발생

    // 콜리(호출자)는 콜백 받는 객체의 주소값을 알고 있어야 한다. (생성자 또는 setter 메서드로 처리)
    public MovieFragment(OnTopAppBarTitleChanged onTopAppBarTitleChanged) {
        this.onTopAppBarTitleChanged = onTopAppBarTitleChanged;
    }

    // 싱글톤 패턴
    public static MovieFragment getInstance(OnTopAppBarTitleChanged onTopAppBarTitleChanged) {
        if (movieFragment == null) {
            movieFragment = new MovieFragment(onTopAppBarTitleChanged);
        }
        return movieFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 엑티비티 실행시 한 번만 호출
        movieService = MovieService.retrofit.create(MovieService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMovieBinding.inflate(inflater, container, false);

        // 리사이클러뷰 만들기
        setupRecyclerView(list);

        if(isFirstLoading) {
            requestMoviesData(currentPageNumber);
        } else {
            setVisibleProgressBar(View.GONE);
        }

        // 화면 그려질때마다 콜백 메서드 호출
        onTopAppBarTitleChanged.setTopAppBar(Define.PAGE_TITLE_MOVIE);

        return binding.getRoot();
    }

    private void requestMoviesData(int requestPage) {

        int ITEM_LIMIT = 10;

        // 통신요청
        movieService.getMovieInfo("rating", ITEM_LIMIT, requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            List<Movie> list = response.body().getData().getMovies();

                            // 어댑터 메소드 호출 -> 리사이클러뷰에 아이템 담기
                            movieAdapter.addItem(list);
                            currentPageNumber++;

                            preventDuplicateScrollEvent = true;
                            isFirstLoading = false;
                            setVisibleProgressBar(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        setVisibleProgressBar(View.GONE);
                        Toast.makeText(binding.getRoot().getContext(), "네트워크 연결이 불안정합니다.", Toast.LENGTH_SHORT).show();
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
        recyclerView.setAdapter(movieAdapter);
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
                            preventDuplicateScrollEvent = false;
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
        // Movie 클래스 직렬화해서 매개변수로 세팅
        intent.putExtra(MovieDetailActivity.PARAM_NAME_1, movie);
        startActivity(intent);
    }

    // 로딩화면(Bar) 세팅
    private void setVisibleProgressBar(int visible) {
        binding.circularProgressIndicator.setVisibility(visible);
    }
}