package com.modacenter.modacenterbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import classes.MyTextView;

public class RedesSociaisActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociais);

        Toolbar redeSocial = (Toolbar) findViewById(R.id.tbredesocial);
        setSupportActionBar(redeSocial);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        MyTextView myTextView = (MyTextView)findViewById(R.id.myTextView);
        ImageView imageView1 = (ImageView) findViewById(R.id.tw);
        ImageView imageView2 = (ImageView) findViewById(R.id.fb);


    }
}
