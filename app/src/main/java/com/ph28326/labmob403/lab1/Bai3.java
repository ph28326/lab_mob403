package com.ph28326.labmob403.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ph28326.labmob403.R;

import java.io.IOException;
import java.net.URL;

public class Bai3 extends AppCompatActivity {
    private ImageView img;
    private ProgressDialog progressDialog;
    private final String link = "https://picsum.photos/400/400";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        img = (ImageView) findViewById(R.id.img);
        Button btnGetImg = (Button) findViewById(R.id.btnGetImg);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Bài 3");
        progressDialog.setMessage("Loading ...");

        AsyncTask<String, Integer, Bitmap> asyncTask = new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... s) {
                URL url;
                Bitmap bitmap = null;
                try {
                    url = new URL(s[0]);
                    bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                super.onPostExecute(result);
                if (result != null) {
                    img.setImageBitmap(result);
                    TextView textView = findViewById(R.id.tvMessage);
                    textView.setText("Image downloaded");
                }
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }
        };

        btnGetImg.setOnClickListener(v -> {
            progressDialog.show();
            asyncTask.execute(link);
        });
    }


}