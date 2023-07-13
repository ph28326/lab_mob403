package com.ph28326.labmob403.lab3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ph28326.labmob403.R;
import com.ph28326.labmob403.lab3.Album;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private List<Album> albums;

    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcvalbum, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.tvId.setText(String.valueOf(album.getId()));
        holder.tvTitle.setText(album.getTitle());
        Picasso.get().load(album.getUrl()).into(holder.ivThumbnail);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvId;
        public ImageView ivThumbnail;

        public ViewHolder(View view) {
            super(view);
            tvId = view.findViewById(R.id.tvAlbumID);
            tvTitle = view.findViewById(R.id.tvTitle);
            ivThumbnail = view.findViewById(R.id.ivThumbnail);
        }
    }
}