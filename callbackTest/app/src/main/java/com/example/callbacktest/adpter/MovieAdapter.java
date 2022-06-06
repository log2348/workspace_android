package com.example.callbacktest.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.callbacktest.R;
import com.example.callbacktest.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> list = new ArrayList<>();

    public void initItemList(List<Movie> list) {
        this.list = list;
        notifyDataSetChanged(); // 리사이클러뷰의 리스트를 업데이트 할 때
    }

    public void addItem(List<Movie> movieList) {
        this.list.addAll(list.size(), movieList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_card_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.setItem(movie);

        holder.itemView.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        private TextView titleTv;
        private ImageView posterIv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            titleTv = itemView.findViewById(R.id.titleTextView);
            posterIv = itemView.findViewById(R.id.posterImageView);
        }

        private void setItem(Movie movie) {
            titleTv.setText(movie.getTitle());

            Glide.with(posterIv.getContext())
                    .load(movie.getMediumCoverImage())
                    .transform(new FitCenter(), new RoundedCorners(20))
                    .into(posterIv);


        }
    }
}
