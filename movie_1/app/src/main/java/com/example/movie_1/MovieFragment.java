package com.example.movie_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movie_1.adapter.MovieAdapter;
import com.example.movie_1.databinding.FragmentMovieBinding;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;
import com.example.movie_1.models.YtsData;
import com.example.movie_1.repository.MovieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment implements OnMovieItemClicked {
    // 안드로이드에서 만들어준 클래스
    private FragmentMovieBinding binding;

    // final - 불변성 위함, 값이 고정되기 때문에 성능에도 좋음
    private static final String TAG = MovieFragment.class.getName();

    // 프래그먼트가 메모리에 올라가는 순간
    // 여기서 통신 요청을 할 예정
    private MovieService movieService;
    private MovieAdapter movieAdapter;
    private List<Movie> list = new ArrayList<>();

    private int currentPageNumber = 1;

    // 스크롤시 중복 이벤트 발생 해결 방안
    private boolean preventDuplicateScrollEvent = true;

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 엑티비티 실행시 한 번만 호출 (라이프 사이클)
        movieService = MovieService.retrofit.create(MovieService.class);
    }

    // 화면 전환했다가 돌아오면 호출됨
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { // 화면을 그릴 때
        // findViewById 대체 (뷰 바인딩 활용)
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        // 리사이클러뷰 만들어주기
        // 아직 없음 (안드로이드는 입체적으로 생각해야 한다)
        setupRecyclerView(list);
        requestMoviesData(currentPageNumber);

        return binding.getRoot();
    }

    private void requestMoviesData(int requestPage) {

        int ITEM_LIMIT = 10;
        Log.d(TAG, "통신 요청 !!!");

        movieService.getMovieInfo("rating", ITEM_LIMIT, requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            // 통신을 통해서 데이터를 넘겨 받았으면 adapter에 데이터를 전달해서
                            // 화면을 갱신 처리
                            List<Movie> list = response.body().getData().getMovies();

                            // 어댑터 메소드 호출
                            movieAdapter.addItem(list);
                            currentPageNumber++;

                            // 통신 끝나면 true값으로 초기화 시켜 줘야 업데이트됨
                            preventDuplicateScrollEvent = true;
                            setVisibilityProgressBar(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                        setVisibilityProgressBar(View.GONE);
                        // xml -> TextView = 네트워크가 불안정 합니다 ( 메서드 작성 )
                    }
                });
    }

    // 통신해서 JSON 파싱해서 받은 다음에 매개변수로 데이터를 넘길 예정
    private void setupRecyclerView(List<Movie> movieList) {
        // 리사이클러뷰 준비물
        // 1. 어댑터
        movieAdapter = new MovieAdapter();
        movieAdapter.addItemList(movieList);
        movieAdapter.setOnMovieItemClicked(this);

        // 2. 매니저
        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        // 3. xml 파일에 선언한 리사이클러뷰에 세팅
        RecyclerView r = binding.movieRecyclerView;
        r.setAdapter(movieAdapter);
        r.setLayoutManager(manager);
        r.setHasFixedSize(true);

        // 이벤트 리스너
        binding.movieRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (preventDuplicateScrollEvent) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) (binding.movieRecyclerView.getLayoutManager());
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, "lastVisibleItemPosition : " + lastVisibleItemPosition);

                    // adapter에 데이터 담겨있음 -> list.size() 꺼내올 수 있다.
                    // 한 번 더 통신 헀을 때
                    // 아이템카운트 10일 때 -> 리니어 레이아웃 매니저는 9로 뽑음
                    int itemTotalCount = binding.movieRecyclerView.getAdapter().getItemCount() - 1;

                    if (lastVisibleItemPosition == itemTotalCount) {

                        if (currentPageNumber != 1) {
                            Log.d(TAG, "check event !!!!!!!!! ");
                            // 계속 네트워크 요청 !!!! -> 버그 발생할 수 있다
                            preventDuplicateScrollEvent = false;
                            requestMoviesData(currentPageNumber); // 2>3>4
                        }
                    }

                }

            }
        });

    }

    private void setVisibilityProgressBar(int visible) {
        binding.progressIndicator.setVisibility(visible); // View.GONE
    }

    @Override
    public void selectedItem(Movie movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        // 직렬화란 object -> byte 단위로 변환해서 처리
        intent.putExtra(MovieDetailActivity.PARAM_NAME_1, movie);
        startActivity(intent);
    }

}