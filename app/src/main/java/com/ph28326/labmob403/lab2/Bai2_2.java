package com.ph28326.labmob403.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ph28326.labmob403.R;
import com.ph28326.labmob403.lab1.Bai2;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Bai2_2 extends AppCompatActivity implements View.OnClickListener {
    public static final String SERVER_NAME1 = "http://192.168.1.254:80/taquangkhanhtoan_ph28326/rectangle_POST.php";
    private EditText edWidth;
    private EditText edLength;
    private Button btnSend;
    private Button btnBack;
    private TextView tvResult;
    String strWidth,strlength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai22);

        edWidth = (EditText) findViewById(R.id.ed_width);
        edLength = (EditText) findViewById(R.id.ed_length);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnBack = (Button) findViewById(R.id.btn_back);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_send){
            strWidth = edWidth.getText().toString();
            strlength = edLength.getText().toString();

            BackgroundTask_POST backgroundTask_post = new BackgroundTask_POST(tvResult,strWidth,strlength, Bai2_2.this);
            backgroundTask_post.execute();
            Log.d("Bai2", "Value of Width: " + strWidth);
            Log.d("Bai2", "Value of Length: " + strlength);
        }
    }
}