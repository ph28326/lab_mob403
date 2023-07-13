package com.ph28326.labmob403.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundTask_GET extends AsyncTask<Void, Void, Void> {
    String duongdan = Bai2_1.SERVER_NAME;
    TextView txtResult;
    String strName, strScore;
    String str;
    ProgressDialog progressDialog;
    Context context;

    public BackgroundTask_GET(TextView txtResult, String strName, String strScore, Context context) {
        this.txtResult = txtResult;
        this.strName = strName;
        this.strScore = strScore;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Sending...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        duongdan += "?name=" + this.strName + "&score=" + this.strScore;
        try {
            URL url = new URL(duongdan);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            StringBuffer sb = new StringBuffer();
            while ((line = bfr.readLine()) != null) {
                sb.append(line);
            }
            str = sb.toString();
            Log.d("BackgroundTask_GET1", "Value of str: " + str);
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        txtResult.setText(str);
        Log.d("BackgroundTask_GET", "Value of str: " + str);
    }


}
