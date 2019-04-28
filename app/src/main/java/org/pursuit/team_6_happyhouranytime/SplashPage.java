package org.pursuit.team_6_happyhouranytime;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SplashPage extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    Handler handler;
    private ImageView clockImageView;
    private TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        clockImageView = findViewById(R.id.splash_imageView);
        handler = new Handler();


        Glide.with(SplashPage.this)
                .load(R.drawable.clock)
                .into(clockImageView);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();


            }
        }, SPLASH_DISPLAY_LENGTH);


    }
}
