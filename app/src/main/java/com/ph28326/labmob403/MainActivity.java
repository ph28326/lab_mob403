package com.ph28326.labmob403;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ph28326.labmob403.lab1.Bai1;
import com.ph28326.labmob403.lab1.Bai2;
import com.ph28326.labmob403.lab1.Bai3;
import com.ph28326.labmob403.lab1.Bai4;
import com.ph28326.labmob403.lab1.MainLab1Activity;
import com.ph28326.labmob403.lab2.MainLab2Activity;


public class MainActivity extends AppCompatActivity {
    Button btnLab1, btnLab2;
    static ImageView imgBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLab1 = findViewById(R.id.btnLab1);
        btnLab2 = findViewById(R.id.btnLab2);


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

    }

    public static Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            Bitmap bitmap = bundle.getParcelable("bitmap");
            if (bitmap != null) {
                imgBanner.setImageBitmap(bitmap);
            }
        }
    };

}