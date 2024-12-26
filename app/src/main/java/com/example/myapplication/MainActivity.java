package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

        webView.loadUrl("file:///android_asset/index.html");
    }

    public class WebAppInterface {
        @JavascriptInterface
        public void playMp3() {
            // Phát nhạc mp3
            Toast.makeText(MainActivity.this, "Phát nhạc mp3", Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void playMp4() {
            // Phát video mp4
            Toast.makeText(MainActivity.this, "Phát video mp4", Toast.LENGTH_SHORT).show();
        }
    }
}
