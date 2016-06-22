package com.modacenter.modacenterbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import classes.MyScrollView;

public class TextActivity extends AppCompatActivity {

    public static final String KEY_FILE_NAME = "KEY_FILE_NAME";
    private TextView mJustifiedText;
    private TextView mText;
    private MyScrollView mScroller;
    private MyScrollView mJustifiedScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        mText = (TextView)findViewById(R.id.text);
        mJustifiedText = (TextView)findViewById(R.id.justified_text);
        String text = "";

        BufferedReader br = null;
        try {
            String fileName = getIntent().getStringExtra(KEY_FILE_NAME);
            br = new BufferedReader(new InputStreamReader(getAssets().open(fileName)));
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
        mText.setText(text);

        mScroller = (MyScrollView)findViewById(R.id.scroller);
        mJustifiedScroller = (MyScrollView)findViewById(R.id.justified_scroller);
        mScroller.setAlternativeScrollView(mJustifiedScroller);
        mJustifiedScroller.setAlternativeScrollView(mScroller);
    }
}
