package com.modacenter.modacenterbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import classes.MyScrollView;

public class ParqueInfoActivity extends AppCompatActivity {

    public static final String KEY_FILE_NAME = "KEY_FILE_NAME";
    private TextView mJustifiedText;
    private MyScrollView mJustifiedScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parque_info);

        mJustifiedScroller = (MyScrollView)findViewById(R.id.justified_scroller2);
        mJustifiedText = (TextView)findViewById(R.id.justified_text2);
        String text = "";

        Toolbar parqInfo = (Toolbar) findViewById(R.id.tbparqInfo);
        setSupportActionBar(parqInfo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BufferedReader br = null;

        try {
            String fileName = getIntent().getStringExtra(KEY_FILE_NAME);
            br = new BufferedReader(new InputStreamReader(getAssets().open(fileName),"ISO-8859-1"));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            text = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        mJustifiedText.setText(text);
        mJustifiedScroller = (MyScrollView)findViewById(R.id.justified_scroller2);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
