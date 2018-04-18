package com.saif.rakbny;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_TIME = 3000;
    private final static int SPLASH_THREAD_FINISHED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startSplashTimer();
    }

    private void startSplashTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                splashDirection();
            }
        }, SPLASH_TIME);
    }

    private void splashDirection() {
        Intent intent = new Intent(this,IntroActivity.class);
        finish();
        startActivity(intent);
    }

}
