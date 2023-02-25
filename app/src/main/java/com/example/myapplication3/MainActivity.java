package com.example.myapplication3;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Boolean is_Start = false;
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
    protected void onDestroy()
    {
        super.onDestroy();
        is_Start = false;
    }
}

