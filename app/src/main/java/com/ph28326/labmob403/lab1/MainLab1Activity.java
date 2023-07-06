package com.ph28326.labmob403.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ph28326.labmob403.MainActivity;
import com.ph28326.labmob403.R;

public class MainLab1Activity extends AppCompatActivity {
    Button btnBai1, btnBai2, btnBai3, btnBai4;
    static ImageView imgBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab1);

        btnBai1 = findViewById(R.id.btnBai1);
        btnBai2 = findViewById(R.id.btnBai2);
        btnBai3 = findViewById(R.id.btnBai3);
        btnBai4 = findViewById(R.id.btnBai4);
        imgBanner = findViewById(R.id.imgBanner);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLab1Activity.this, Bai1.class);
                startActivity(intent);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLab1Activity.this, Bai2.class);
                startActivity(intent);
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLab1Activity.this, Bai3.class);
                startActivity(intent);
            }
        });
        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLab1Activity.this, Bai4.class);
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