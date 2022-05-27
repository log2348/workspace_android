
package com.example.viewpager2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.viewpager2.R;

import java.util.ArrayList;

public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> slideImage;

    public ImageSliderAdapter(Context context, ArrayList<String> slideImage) {
        this.context = context;
        this.slideImage = slideImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_image_slider, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 뷰 홀더에 넣을 데이터
        // http://image.jpg 세팅
        holder.bindSlideImage(slideImage.get(position));
    }

    @Override
    public int getItemCount() {
        return slideImage.size();
    }

    // 뷰 홀더 생성 (findViewId() 줄이기 위함 -> 성능개선)
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlider);
        }

        public void bindSlideImage(String imageURL) {
            Glide.with(context)
                    .load(imageURL)
                    .centerCrop()
                    .into(imageView);
        }
    } // end of inner class
}

