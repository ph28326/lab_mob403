package com.ph28326.labmob403.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ph28326.labmob403.R;
import com.ph28326.labmob403.lab1.Bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai2_1 extends AppCompatActivity {

    public static final String SERVER_NAME = "http://localhost/taquangkhanhtoan_ph28326/student_GET.php";

    EditText edName, edScore;
    Button btnSend;
    TextView txtResult;
    String strName, strScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai21);

        edName = findViewById(R.id.edName);
        edScore = findViewById(R.id.edScore);
        btnSend = findViewById(R.id.btnSend);
        txtResult = findViewById(R.id.txtResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btnSend) {
                    strName = edName.getText().toString();
                    strScore = edScore.getText().toString();

                    BackgroundTask_GET backgroundTask = new BackgroundTask_GET(txtResult, strName, strScore, Bai2_1.this);
                    backgroundTask.execute();
                    Log.d("Bai1", "Value of name: " + strName);
                    Log.d("Bai1", "Value of score: " + strScore);
                }
            }
        });
    }

}