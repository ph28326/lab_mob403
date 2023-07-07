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

public class BackgroundTask_GET extends AsyncTask<String, Integer, String> {
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
        this.context = (Context) context;
    }

    @Override
    protected String doInBackground(String... strings) {
        duongdan += "?name=" + this.strName + "?score=" + this.strScore;

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            bufferedReader.close();
            str = stringBuffer.toString();
            urlConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Sending...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        txtResult.setText(str);
        Log.d("result1123", "result: "+ str);

    }

}
