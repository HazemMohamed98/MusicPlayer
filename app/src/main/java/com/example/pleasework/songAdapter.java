package com.example.pleasework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class songAdapter extends RecyclerView.Adapter<songAdapter.MyViewHolder> {

    private List<Song> songList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, artist;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            artist = view.findViewById(R.id.artist);
            image = view.findViewById(R.id.image);
        }
    }

    public songAdapter(List<Song> songList) {
        this.songList = songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public songAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.song_adapter, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull songAdapter.MyViewHolder myViewHolder, int i) {
        Song song = songList.get(i);
        myViewHolder.title.setText(song.getName());
        myViewHolder.artist.setText(song.getArtist().name);

        //Trials to get the image to work
        //myViewHolder.image.setImageURI(Uri.parse(song.getAlbumArtLocation()));
        //myViewHolder.image.setImageBitmap(song.getBitmap());
        //myViewHolder.image.setImageURI(Uri.parse(song.getLocation()));
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}