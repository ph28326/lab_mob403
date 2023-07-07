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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bai2_1 extends AppCompatActivity {

    public static final String SERVER_NAME = "http://localhost/taquangkhanhtoan_ph28326/student_get.php";

    EditText edName, edScore;
    Button btnSend;
    TextView txtResult;
    String strName, strScore;
    ProgressDialog progressDialog;
    AsyncTask<String, Integer, String> asyncTask;

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

                strName = edName.getText().toString();
                strScore = edScore.getText().toString();
                String query = "?name=" + strName + "?score=" + strScore;
                asyncTask = new AsyncTask<String, Integer, String>() {
                    @Override
                    protected String doInBackground(String... strings) {
                        String line;
                        StringBuffer buffer = null;
                        try {
                            URL url = new URL(strings[0]);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                            int responseCode = connection.getResponseCode();
                            if (responseCode == connection.HTTP_OK) {
                                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                                buffer = new StringBuffer();
                                while ((line = reader.readLine()) != null) {
                                    buffer.append(line);
                                }
                                reader.close();
                                connection.disconnect();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return buffer.toString();
                    }

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        progressDialog = new ProgressDialog(Bai2_1.this);
                        progressDialog.setMessage("Sending...");
                        progressDialog.setIndeterminate(false);
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                        txtResult.setText(s);
                        Log.d("result1123", "result: " + s);
                    }
                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        super.onProgressUpdate(values);
                    }
                };
                asyncTask.execute(SERVER_NAME + query);
            }
        });
    }


}