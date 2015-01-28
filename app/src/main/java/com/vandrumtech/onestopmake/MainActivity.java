package com.vandrumtech.onestopmake;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class MainActivity extends Activity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(CheckNetwork.isInternetAvailable(MainActivity.this)) //returns true if internet available
        {
            myWebView = (WebView) findViewById(R.id.webview);
            myWebView.setWebViewClient(new WebViewClient());
            myWebView.loadUrl(getString(R.string.url));
        }
        else
        {
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (myWebView != null && myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
