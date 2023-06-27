package com.ph28326.labmob403;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Bai2 extends AppCompatActivity {
    private ImageView img;
    private Button btnGetImg;
    private ProgressDialog progressDialog;
    private final String link = "https://picsum.photos/200/400";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        img = (ImageView) findViewById(R.id.img);
        btnGetImg = (Button) findViewById(R.id.btn_getImg);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Bài 2");
        progressDialog.setMessage("Loading ...");

        btnGetImg.setOnClickListener(v -> {
            showImage();
            progressDialog.show();
        });
    }

    private void showImage() {
        new Thread(() -> {
            final Bitmap bitmapImg = getImage(link);
            runOnUiThread(() -> {
                if (bitmapImg != null) {
                    img.setImageBitmap(bitmapImg);
                    TextView textView = findViewById(R.id.tvMessage);
                    textView.setText("Image downloaded");
                    progressDialog.dismiss();
                }
            });
        }).start();
    }

    private Bitmap getImage(String link) {
        URL url;
        Bitmap bitmap = null;

        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}