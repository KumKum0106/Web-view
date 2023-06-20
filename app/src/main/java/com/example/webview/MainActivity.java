package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);
        webview.loadUrl("https://google.com"); // It will load this URL on the Screen

        webview.setWebViewClient(new WebViewClient(){ // loadData() – Load Static Html Data on WebView
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE); // When Page is Loading, Progress Bar will be visible to us
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE); // When Page Loading is completed, Progress Bar visibility will be gone
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            // canGoBack() – Move to one page back if a back history exist. By clicking on the back button we can go just to the previous screen. Without this, we were going out of the app by clicking on the back
            // canGoForward() – Move one page forward if forward history exist
            webview.goBack();
        }else{
            super.onBackPressed();
        }
    }
}