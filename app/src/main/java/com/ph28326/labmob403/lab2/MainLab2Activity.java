package com.ph28326.labmob403.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ph28326.labmob403.MainActivity;
import com.ph28326.labmob403.R;
import com.ph28326.labmob403.lab1.MainLab1Activity;

public class MainLab2Activity extends AppCompatActivity {
    Button btnBai1, btnBai2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab2);

        btnBai1 = findViewById(R.id.btnBai1);
        btnBai2 = findViewById(R.id.btnBai2);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLab2Activity.this, Bai2_1.class);
                startActivity(intent);
            }
        });

        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLab2Activity.this, Bai2_2.class);
                startActivity(intent);
            }
        });
    }
}