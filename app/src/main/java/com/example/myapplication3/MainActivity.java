package com.example.myapplication3;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Boolean is_Start = false;
    private Boolean ButtonStatus = true;
    private int counter = 0;
    private TextView TV1;
    private Button B1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV1 = findViewById(R.id.TV);
        B1 = findViewById(R.id.button1);
    }

    public void onClickStart(View View) {
        is_Start = true;
        if (ButtonStatus) {
            ButtonStatus=false;
            //counter = 0;
            B1.setText("STOP");
            B1.setTextColor(Color.RED);
        } else
        {is_Start = false;
        ButtonStatus = true;
        //counter = 0;
        B1.setText("START");
        B1.setTextColor(Color.WHITE);};
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(is_Start)
                {
                    counter++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TV1.setText(String.valueOf(counter));
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        }).start();
        }
    public void onClickFinish (View View)
    {
        super.onDestroy();
        is_Start = false;
    }
    protected void onDestroy()
    {
        super.onDestroy();
        is_Start = false;
    }
}

