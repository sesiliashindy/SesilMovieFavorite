package com.example.user.sesilmoviefavorite.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.user.sesilmoviefavorite.R;
import com.example.user.sesilmoviefavorite.model.MovieFavorite;

import java.util.ArrayList;

public class GridMovieAdapter  extends RecyclerView.Adapter<GridMovieAdapter.GridViewHolder>{
    private static final String IMG_BASE = "http://image.tmdb.org/t/p/";

    public GridMovieAdapter(ArrayList<MovieFavorite> movies) {
        this.movies = movies;
    }

    public void setMovies(ArrayList<MovieFavorite> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    private ArrayList<MovieFavorite> movies;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public GridMovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    private Context context;


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_movie_tv, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        MovieFavorite movieFavorite = movies.get(i);

        Glide.with(context)
                .load(IMG_BASE+"W185"+ movieFavorite.getPoster())
                .apply(new RequestOptions().override(500,500))
                .into(gridViewHolder.moviePhoto);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePhoto;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
