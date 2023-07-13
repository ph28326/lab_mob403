package com.ph28326.labmob403.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.ph28326.labmob403.MainActivity;
import com.ph28326.labmob403.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Bai3_1c2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai31c2);

        recyclerView = findViewById(R.id.rcAlbum);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiAlbumService apiService = new Retrofit.Builder()
                .baseUrl(ApiAlbumService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiAlbumService.class);

        Call<List<Album>> call = apiService.getAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> photos = response.body();

                adapter = new AlbumAdapter(photos);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Toast.makeText(Bai3_1c2.this, "Failed to get photos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}