package com.woodys.remwebview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebSettings webSetting;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_main);
        webView=(WebView)findViewById(R.id.webView);
        webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(false);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSetting.setDomStorageEnabled(true);
        webSetting.setDatabaseEnabled(true);
        webSetting.setAppCacheEnabled(false);
        webSetting.setMinimumFontSize(1);
        webSetting.setMinimumLogicalFontSize(1);
        webSetting.setAppCacheMaxSize(1024 * 1024 * 8);
        //启用地理定位
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheEnabled(false);

        Intent intent = getIntent();
        if (null!=intent){
            webView.loadUrl(intent.getStringExtra("url"));
        }

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
    }
}
