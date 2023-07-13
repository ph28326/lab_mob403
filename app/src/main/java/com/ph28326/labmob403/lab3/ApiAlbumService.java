package com.ph28326.labmob403.lab3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiAlbumService {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("photos")
    Call<List<Album>> getAlbums();
}
