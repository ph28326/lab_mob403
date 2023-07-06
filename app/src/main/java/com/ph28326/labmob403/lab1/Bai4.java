package com.ph28326.labmob403.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ph28326.labmob403.R;

public class Bai4 extends AppCompatActivity {
    private EditText edTime;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        edTime = (EditText) findViewById(R.id.edTime);
        Button btnRun = (Button) findViewById(R.id.btnRun);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Bài 4");
        progressDialog.setProgressStyle(androidx.appcompat.R.style.Base_Widget_AppCompat_ProgressBar_Horizontal);
        progressDialog.setProgress(0);

        AsyncTask<Integer, Integer, Boolean> asyncTask = new AsyncTask<Integer, Integer, Boolean>() {
            @Override
            protected Boolean doInBackground(Integer... integers) {
                int second = integers[0];
                try {
                    for (int i = second; i > 0; i--) {
                        publishProgress(i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if (progressDialog.isShowing() && aBoolean) {
                    progressDialog.dismiss();
                }
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressDialog.setMessage("Please wait " + values[0]);
                progressDialog.incrementProgressBy(1);
            }
        };

        btnRun.setOnClickListener(v -> {
            String input = edTime.getText().toString();
            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            } else {
                int seconds = Integer.parseInt(input);
                progressDialog.setMax(seconds);
                progressDialog.setMessage("Please wait " + seconds);
                progressDialog.show();
                asyncTask.execute(seconds);
            }
        });
    }
}

