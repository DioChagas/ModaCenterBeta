package com.modacenter.modacenterbeta;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(this,2000);
    }

    @Override
    public void run() {
        Intent i = new Intent(this,TelaInicialActivity.class);
        startActivity(i);
        finish();

    }
}
