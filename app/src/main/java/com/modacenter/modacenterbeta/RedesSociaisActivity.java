package com.modacenter.modacenterbeta;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://twitter.com/Moda_Center");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(RedesSociaisActivity.this,"Redirecionando...", Toast.LENGTH_SHORT).show();
                //Toast.makeText(RedesSociaisActivity.this,"Em breve!", Toast.LENGTH_SHORT).show();
            }
        });


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/modacentersantacruz/?fref=ts");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                Toast.makeText(RedesSociaisActivity.this,"Redirecionando...", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
