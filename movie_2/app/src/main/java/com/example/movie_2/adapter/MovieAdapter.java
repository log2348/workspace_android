package com.example.movie_2.adapter;

import android.util.Log;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.movie_2.R;
import com.example.movie_2.interfaces.OnMovieItemViewClicked;
import com.example.movie_2.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();
    private OnMovieItemViewClicked onMovieItemViewClicked;

    public void setOnMovieItemViewClicked(OnMovieItemViewClicked onMovieItemViewClicked) {
        this.onMovieItemViewClicked = onMovieItemViewClicked;
    }

    public void initItemList(List<Movie> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addItem(List<Movie> addList) {
        // 기존에 이미 호출되어있는 리스트에 네트워크 통신으로 새로 넘어온 데이터 추가
        this.list.addAll(list.size(), addList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);

        holder.setItem(movie);
        holder.itemView.setOnClickListener(view -> {
            onMovieItemViewClicked.selectedItem(movie);
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private ImageView posterIv;
        private TextView titleTv;
        private TextView ratingTv;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            posterIv = itemView.findViewById(R.id.posterIv);
            titleTv = itemView.findViewById(R.id.movieTitleTv);
            ratingTv = itemView.findViewById(R.id.ratingTv);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        private void setItem(Movie movie) {
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
    }
}
