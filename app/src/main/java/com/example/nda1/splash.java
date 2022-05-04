package com.example.nda1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {
    public static  final long SPLASH_SCREEN_DELAY=6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView logouac=findViewById(R.id.imageViewuac);
        ImageView imgandroid=findViewById(R.id.imageViewandroid);
        TextView txtnombre=findViewById(R.id.textNombre);
        TextView txtcurso=findViewById(R.id.textCurso);
        TextView txtproyecto=findViewById(R.id.textproyecto);
        imgandroid.setAnimation( AnimationUtils.loadAnimation(this, R.anim.anim2));
        txtnombre.setAnimation( AnimationUtils.loadAnimation(this, R.anim.anim3));
        txtcurso.setAnimation( AnimationUtils.loadAnimation(this, R.anim.anim3));
        txtproyecto.setAnimation( AnimationUtils.loadAnimation(this, R.anim.anim3));
        logouac.setAnimation( AnimationUtils.loadAnimation(this, R.anim.logoandina));
        TimerTask time=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent().setClass(splash.this,MainActivity.class);

                startActivity(intent);
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(time,SPLASH_SCREEN_DELAY);
    }
}