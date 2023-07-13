package com.ph28326.labmob403;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.ph28326.labmob403.lab1.MainLab1Activity;
import com.ph28326.labmob403.lab2.MainLab2Activity;
import com.ph28326.labmob403.lab3.MainLab3Activity;


public class MainActivity extends AppCompatActivity {
    Button btnLab1, btnLab2, btnLab3,btnLab4, btnLab5, btnLab6, btnLab7, btnLab8;
    static ImageView imgBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLab1 = findViewById(R.id.btnLab1);
        btnLab2 = findViewById(R.id.btnLab2);
        btnLab3 = findViewById(R.id.btnLab3);


        btnLab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainLab1Activity.class);
                startActivity(intent);
            }
        });
        btnLab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainLab2Activity.class);
                startActivity(intent);
            }
        });

        btnLab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainLab3Activity.class);
                startActivity(intent);
            }
        });

    }

}