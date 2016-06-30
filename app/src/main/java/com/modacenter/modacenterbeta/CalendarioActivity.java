package com.modacenter.modacenterbeta;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import classes.URLSpanNoUnderline;

public class CalendarioActivity extends AppCompatActivity {

    // private Animator mCurrentAnimator;
    // private int mShortAnimationDuration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        Toolbar calendario = (Toolbar) findViewById(R.id.tbcalendario);
        setSupportActionBar(calendario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final TextView textView = (TextView) findViewById(R.id.Tvcliqueaqui);



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(CalendarioActivity.this);

                alerta
                        .setTitle("AVISO")
                        .setIcon(R.drawable.mc_blog_ns)
                        .setCancelable(false)
                        .setMessage("Deseja fazer download do calendário?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = Uri.parse("http://www.modacentersantacruz.com.br/calendario.pdf");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(CalendarioActivity.this,"Redirecionando...", Toast.LENGTH_SHORT).show();

                    }
                });

                alerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(CalendarioActivity.this,TelaInicialActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = alerta.create();
                alerta.show();
            }
        });


        stripUnderlines(textView);
    }



    private void stripUnderlines(TextView textView) {
        Spannable s = new SpannableString(textView.getText());
        URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
        for (URLSpan span: spans) {
            int start = s.getSpanStart(span);
            int end = s.getSpanEnd(span);
            s.removeSpan(span);
            span = new URLSpanNoUnderline(span.getURL());
            s.setSpan(span, start, end, 0);
        }
        textView.setText(s);
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
