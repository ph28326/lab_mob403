package com.ph28326.labmob403.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.ph28326.labmob403.MainActivity;
import com.ph28326.labmob403.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Bai3_1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AlbumAdapter adapter;
    private List<Album> albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai31);
        recyclerView = findViewById(R.id.rcAlbum);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        albums = new ArrayList<>();
        adapter = new AlbumAdapter(albums);
        recyclerView.setAdapter(adapter);

        new GetAlbums().execute();
    }

    private class GetAlbums extends AsyncTask<Void, Void, List<Album>> {

        @Override
        protected List<Album> doInBackground(Void... voids) {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/photos");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    response.append(line);
                }

                JSONArray jsonArray = new JSONArray(response.toString());
                List<Album> albums = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("albumId");
                    String title = jsonObject.getString("title");
                    String urll = jsonObject.getString("thumbnailUrl");
                    albums.add(new Album(id, title, urll));
                }

                return albums;

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<Album> albums) {
            if (albums != null) {
                Bai3_1.this.albums.addAll(albums);
                adapter.notifyDataSetChanged();
            }
        }
    }
}