package com.example.movie_2;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.movie_2.databinding.FragmentInfoBinding;
import com.example.movie_2.interfaces.OnTopAppBarTitleChanged;
import com.example.movie_2.interfaces.OnWebViewBackPressed;
import com.example.movie_2.utils.Define;

public class InfoFragment extends Fragment {

    private FragmentInfoBinding binding;
    // 싱글톤 패턴
    private static InfoFragment infoFragment;
    private OnTopAppBarTitleChanged onTopAppBarTitleChanged;
    private OnWebViewBackPressed onWebViewBackPressed;
    private WebView webView;

    public void setOnWebViewBackPressed(OnWebViewBackPressed onWebViewBackPressed) {
        this.onWebViewBackPressed = onWebViewBackPressed;
    }

    public InfoFragment(OnTopAppBarTitleChanged onTopAppBarTitleChanged) {
        this.onTopAppBarTitleChanged = onTopAppBarTitleChanged;
    }

    public static InfoFragment getInstance(OnTopAppBarTitleChanged onTopAppBarTitleChanged) {
        if (infoFragment == null) {
            infoFragment = new InfoFragment(onTopAppBarTitleChanged);
        }
        return infoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInfoBinding.inflate(inflater, container, false);
        onTopAppBarTitleChanged.setTopAppBar(Define.PAGE_TITLE_INFO);
        setupWebView();
        return binding.getRoot();
    }

    private void setupWebView() {
        webView = binding.mWebView;
        webView.loadUrl("https://yts.mx/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                binding.circularProgressIndicatorInfo.setVisibility(View.GONE);
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        onWebViewBackPressed.onPassWebViewPage(webView);
    }
}