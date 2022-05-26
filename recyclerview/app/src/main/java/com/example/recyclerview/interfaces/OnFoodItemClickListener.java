package com.example.recyclerview.interfaces;

import android.view.View;

// 콜백 메서드
public interface OnFoodItemClickListener {
    void onItemClicked(View view, int position);
}
