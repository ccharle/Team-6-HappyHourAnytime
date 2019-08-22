package org.pursuit.team_6_happyhouranytime;

import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;

public class SplashPage extends AppCompatActivity {
    Handler handler;
    @BindView(R.id.splash_imageView) ImageView clockImageView;
    private TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        handler = new Handler();
//
//
//        Glide.with(SplashPage.this)
//                .load(R.drawable.clock)
//                .into(clockImageView);
//
        int SPLASH_DISPLAY_LENGTH = 2000;
        handler.postDelayed(() -> {
           Intent intent = new Intent(getApplicationContext(), MainActivity.class);
           startActivity(intent);
           finish();
//
//
       }, SPLASH_DISPLAY_LENGTH);
//
//
   }
}
