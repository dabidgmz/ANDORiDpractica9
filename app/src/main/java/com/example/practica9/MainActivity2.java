package com.example.practica9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        new CountDownTimer(5000, 1000) { // 5000 milisegundos = 5 segundos

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        }.start();
    }
}