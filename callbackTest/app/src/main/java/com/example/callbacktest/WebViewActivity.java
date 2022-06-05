package com.example.callbacktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.mWebView);
        webView.loadUrl("http://blog.naver.com/pjh4794");
        
        webView.getSettings().setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {

        if(webView.canGoBack()) {
            webView.goBack();
            Log.d("TAG", "onBackPressed()");
            Toast.makeText(this, "한 번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else {
        }
    }
}