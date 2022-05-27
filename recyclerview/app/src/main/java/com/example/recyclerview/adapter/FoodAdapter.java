package com.example.recyclerview.adapter;

/*
    뷰 홀더 만들기
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.OnFoodItemClickListener;
import com.example.recyclerview.models.Food;

import java.util.ArrayList;

// 데이터와 뷰 연결시키는 클래스
// findByViewId를 대신 처리해줌
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    // 멤버 변수
    ArrayList<Food> list;
    Context context;
    OnFoodItemClickListener onFoodItemClickListener;

    public FoodAdapter(ArrayList<Food> list, Context context, OnFoodItemClickListener onFoodItemClickListener) {
        this.list = list;
        this.context = context;
        this.onFoodItemClickListener = onFoodItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // new ViewHolder 생성해

        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_food, parent, false);

        return new MyViewHolder(itemView);
    }

    // 화면 크기만큼 보이도록 하고 점점 생성하기 때문에 사용자에게 빠르게 로드되도록 할 수 있다 (유연함)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // BindViewHolder (화면과 연결)
        // 데이터 맵핑
        Log.d("TAG", "position : " + position);
        Food food = list.get(position);
        Glide.with(context)
                .load(food.getThumnbail())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnail);
        holder.titleTextView.setText(food.getTitle());
        holder.subTitleTextView.setText(food.getSubtitle());
        holder.detailTextView.setText(food.getDetail());

    }

    @Override
    public int getItemCount() {
        // 아이템이 몇개있는지 알려달라 -> 스크롤 처리 할지말지 정해야 하니까
        return list.size();
    }

    // 1. 내부 클래스 만들기
    // 뷰 홀더를 미리 하나 만들어두고 일일이 했던 findViewById()를 재활용해서 쓰는 것 (성능 개선)
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView titleTextView;
        TextView subTitleTextView;
        TextView detailTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleTextView = itemView.findViewById(R.id.subTitleTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);

            itemView.setOnClickListener(view -> {
                Toast.makeText(view.getContext(),
                        "TEST" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                // 콜백 메서드 호출
                onFoodItemClickListener.onItemClicked(itemView, getLayoutPosition());
            });

        }
    } // end of inner class
}
