package com.ph28326.labmob403.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ph28326.labmob403.R;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Bai2_2 extends AppCompatActivity {
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai22);

        tvResult = findViewById(R.id.tv_result);

        // Lấy dữ liệu từ bàn phím
        EditText etWidth = findViewById(R.id.et_width);
        EditText etHeight = findViewById(R.id.et_height);
        int width = Integer.parseInt(etWidth.getText().toString());
        int height = Integer.parseInt(etHeight.getText().toString());

        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo một kết nối HTTP POST đến server
                OkHttpClient client = new OkHttpClient();
                String url = "http://localhost/chuvi.php/";
                RequestBody requestBody = new FormBody.Builder()
                        .add("width", String.valueOf(width))
                        .add("height", String.valueOf(height))
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();

                // Gửi yêu cầu đến server và nhận kết quả trả về
                try {
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();

                    // Hiển thị kết quả trên textview
                    tvResult.setText(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}