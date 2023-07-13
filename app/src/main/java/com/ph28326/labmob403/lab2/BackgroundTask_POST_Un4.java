package com.ph28326.labmob403.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.ph28326.labmob403.lab1.Bai4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_POST_Un4 extends AsyncTask<String, Void, Void> {
    String duongdan = Bai2_4.SERVER_NAME3;
    Context context;
    TextView tvResult;
    String strResult;
    ProgressDialog progressDialog;
    String strA, strB, strC;

    public BackgroundTask_POST_Un4(Context context, TextView tvResult, String strA, String strB, String strC) {
        this.context = context;
        this.tvResult = tvResult;
        this.strA = strA;
        this.strB = strB;
        this.strC = strC;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("sendding...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            URL url = new URL(duongdan);
            String param = "a=" + URLEncoder.encode(strA, "utf-8")
                    + "&b=" + URLEncoder.encode(strB, "utf-8")
                    + "&c=" + URLEncoder.encode(strC, "utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader bft = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = bft.readLine()) != null){
                sb.append(line);
            }
            strResult = sb.toString();
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
        tvResult.setText(strResult);
    }
}