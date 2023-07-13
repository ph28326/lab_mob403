package com.ph28326.labmob403.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ph28326.labmob403.R;
import com.ph28326.labmob403.lab2.Bai2_1;
import com.ph28326.labmob403.lab2.Bai2_2;
import com.ph28326.labmob403.lab2.MainLab2Activity;

public class MainLab3Activity extends AppCompatActivity {
    Button btnBai1, btnBai2, btnBai1c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab3);
        btnBai1 = findViewById(R.id.btnBai1);
        btnBai1c2 = findViewById(R.id.btnBai1c2);
        btnBai2 = findViewById(R.id.btnBai2);

        btnBai1.setOnClickListener(view -> {
            Intent intent = new Intent(MainLab3Activity.this, Bai3_1.class);
            startActivity(intent);
        });
        btnBai1c2.setOnClickListener(view -> {
            Intent intent = new Intent(MainLab3Activity.this, Bai3_1c2.class);
            startActivity(intent);
        });

//        btnBai2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainLab3Activity.this, Bai2_2.class);
//                startActivity(intent);
//            }
//        });
    }
}