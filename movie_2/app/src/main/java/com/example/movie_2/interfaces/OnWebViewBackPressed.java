package com.example.movie_2.interfaces;

import android.webkit.WebView;

// 웹뷰 화면에서 뒤로가기 기능 구현
public interface OnWebViewBackPressed {
    void onPassWebViewPage(WebView webView);
}
