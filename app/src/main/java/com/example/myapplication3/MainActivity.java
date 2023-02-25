package com.example.myapplication3;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Boolean is_Start = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickStart(View View) {
        is_Start = true;
        new Thread(new Runnable() {
            @Override
            public void run() {

            }


        }).start();
        }
    protected void onDestroy()
    {
        super.onDestroy();
        is_Start = false;
    }
}

