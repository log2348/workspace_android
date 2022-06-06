package com.example.callbacktest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.callbacktest.databinding.FragmentWebViewBinding;

public class WebViewFragment extends Fragment {

    private FragmentWebViewBinding binding;
    private WebView webView;

    private static WebViewFragment webViewFragment;

    public WebViewFragment() {
        // Required empty public constructor
    }

    public static WebViewFragment getInstance() {

        if (webViewFragment == null) {
            webViewFragment = new WebViewFragment();
        }
        return webViewFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = binding.mWebView;
        webView.loadUrl("https://yts.mx/");
        webView.getSettings().setJavaScriptEnabled(true);
        Log.d("TAG", "OnCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWebViewBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

}