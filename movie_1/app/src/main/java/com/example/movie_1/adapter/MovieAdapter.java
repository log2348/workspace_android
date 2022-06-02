package com.example.movie_1.adapter;

// 내부 클래스 먼저 만들기

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// R -> Resource (리소스 파일들 총 관리)
import com.example.movie_1.R;

public class MovieAdapter {

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
    } // end of inner class

}
