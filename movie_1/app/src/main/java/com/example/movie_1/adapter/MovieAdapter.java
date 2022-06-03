package com.example.movie_1.adapter;

// 내부 클래스 먼저 만들기

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// R -> Resource (리소스 파일들 총 관리)
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.movie_1.R;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();
    private OnMovieItemClicked onMovieItemClicked;

    public OnMovieItemClicked getOnMovieItemClicked() {
        return onMovieItemClicked;
    }

    public void setOnMovieItemClicked(OnMovieItemClicked onMovieItemClicked) {
        this.onMovieItemClicked = onMovieItemClicked;
    }

    // 통신 배우기 전 -> 생성자에서 데이터를 전달 받아서 화면을 구성
    // 통신이기 때문에 화면을 그리는 시점보다 더 늦게 데이터가 도달할 수 있다.

    // 그 전에 호출된 데이터들이 스크롤바 내리고 다시 올렸을 때 없어지는(교체되는) 이유
    public void addItemList(List<Movie> list) {
        this.list = list;
        // 데이터가 변경되었으면(알려주면) 화면을 다시 그려줌
        notifyDataSetChanged();
    }

    // 교체말고 append 해야한다
    public void addItem(List<Movie> addList) {
        // 그 전 데이터들도 넣어줘야함
        this.list.addAll(list.size(), addList); // 기존에 호출되어있던 리스트에 네트워크 통신으로 넘어온 데이터 추가해주는 거
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        // 여기에서 바로 세팅하는 타입

        // view holder 안에서 세팅하는 타입 (메소드 만들기)
        holder.setItem(movie);
        holder.itemView.setOnClickListener(view -> {
            onMovieItemClicked.selectedItem(movie);
        });
    }

    @Override
    public int getItemCount() { // 몇개의 리스트를 그릴건지
        return list.size();
    }

    // inner static class 내부 정적 클래스
    // 뷰 결합(view binding) x (직접 해야 한다.)
    // 뷰 바인딩은 단 방향 (xml 파일 -> java)
    // data binding 뷰 결합 (양방향) (xml 파일에서 변수 선언해서 데이터 넣는 거)
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // itemView에 선언한 데이터 타입을 선언하고 생성 시점에 R.id.xxx 연결 해주면 된다.
        private View itemView;
        private ImageView posterIv;
        private TextView titleTv;
        private TextView ratingTv;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterIv = itemView.findViewById(R.id.posterIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            ratingTv = itemView.findViewById(R.id.ratingTv);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public void setItem(Movie movie) {
            titleTv.setText(movie.getTitle());
            ratingTv.setText(String.valueOf(movie.getRating()));
            ratingBar.setRating((float) movie.getRating());

            Glide.with(posterIv.getContext())
                    .load(movie.getMediumCoverImage())
                    .placeholder(R.drawable.round_image)
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterIv);

            itemView.setOnClickListener(view -> {
                Log.d("TAG", "" + view.getContext());
            });
        }

    } // end of inner class

}
