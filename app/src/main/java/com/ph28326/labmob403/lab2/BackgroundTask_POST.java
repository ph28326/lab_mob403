package com.ph28326.labmob403.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.ph28326.labmob403.lab1.Bai2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_POST extends AsyncTask<Void, Void, Void> {
    String duongdan = Bai2_2.SERVER_NAME1;
    TextView tvResult;
    String strWidth, strLength;
    String str;
    ProgressDialog progressDialog;
    Context context;

    public BackgroundTask_POST(TextView tvResult, String strWidth, String strLength, Context context) {
        this.tvResult = tvResult;
        this.strWidth = strWidth;
        this.strLength = strLength;
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
        //duongdan += "?chieurong=" + this.strWidth + "&chieudai=" + this.strLength;
        try {
            URL url = new URL(duongdan);
            String param= "chieurong=" + URLEncoder.encode(strWidth, "utf-8")+ "&chieudai="
                    + URLEncoder.encode(strLength, "utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader btf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = btf.readLine()) != null){
                sb.append(line);
            }
            str= sb.toString();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(str);
    }
}