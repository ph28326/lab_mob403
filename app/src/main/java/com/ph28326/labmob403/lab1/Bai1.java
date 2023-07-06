package com.ph28326.labmob403.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ph28326.labmob403.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai1 extends AppCompatActivity {
    Button btnLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        btnLoad = findViewById(R.id.btnLoad);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadImageThread thread = new DownloadImageThread();
                thread.start();
            }
        });

    }
    private class DownloadImageThread extends Thread {
        @Override
        public void run() {
            try {
                URL url = new URL("https://picsum.photos/536/354");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(input);

                // Update UI on the main thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ImageView imageView = findViewById(R.id.imgAndroid);
                        imageView.setImageBitmap(bitmap);
                        TextView textView = findViewById(R.id.tvMessage);
                        textView.setText("Image Downloaded");
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}