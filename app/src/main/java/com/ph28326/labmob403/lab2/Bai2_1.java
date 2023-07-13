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

public class Bai2_1 extends AppCompatActivity implements View.OnClickListener{
    public static final String SERVER_NAME = "http://192.168.1.254:80/taquangkhanhtoan_ph28326/student_GET.php";
    private EditText edName;
    private EditText edScore;
    private Button btnSend;
    private TextView tvResult;
    private Button btnBack;


    String strName,strScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai21);
        edName = (EditText) findViewById(R.id.ed_name);
        edScore = (EditText) findViewById(R.id.ed_score);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnBack = (Button) findViewById(R.id.btn_back);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnBack.setOnClickListener(this);
        btnSend.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_send){
            strName = edName.getText().toString();
            strScore = edScore.getText().toString();

            BackgroundTask_GET backgroundTask = new BackgroundTask_GET(tvResult,strName,strScore,Bai2_1.this);
            backgroundTask.execute();
            Log.d("Bai1", "Value of name: " + strName);
            Log.d("Bai1", "Value of score: " + strScore);

        }
    }
}