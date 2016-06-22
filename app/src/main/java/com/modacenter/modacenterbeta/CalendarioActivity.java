package com.modacenter.modacenterbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CalendarioActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        TextView textView = (TextView) findViewById(R.id.Tvcliqueaqui);
        ImageView imageView = (ImageView) findViewById(R.id.calendar);



        Toolbar calendario = (Toolbar) findViewById(R.id.tbcalendario);
        setSupportActionBar(calendario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }




}
