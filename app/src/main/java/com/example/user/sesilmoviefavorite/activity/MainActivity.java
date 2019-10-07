package com.example.user.sesilmoviefavorite.activity;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.user.sesilmoviefavorite.R;
import com.example.user.sesilmoviefavorite.adapter.GridMovieAdapter;
import com.example.user.sesilmoviefavorite.model.MovieFavorite;

import java.util.ArrayList;

import static com.example.user.sesilmoviefavorite.Contract.CONTENT_URI;
import static com.example.user.sesilmoviefavorite.helper.MovieHelper.mapCursorToArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMovie;
    ProgressBar pbMovie;
    GridMovieAdapter gridMovieAdapter;
    ArrayList<MovieFavorite> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = new ArrayList<>();
        rvMovie = findViewById(R.id.rv_movie);
        pbMovie = findViewById(R.id.progress_bar_movie);

        showRecyclerGridMovie();
        if (savedInstanceState == null) {
            loadData();
        } else {
            movies = savedInstanceState.getParcelableArrayList("movie_list");
            if (movies != null) {
                gridMovieAdapter.setMovies(movies);
            }
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("movie_list", movies);
    }

    private void showRecyclerGridMovie(){
        rvMovie.setLayoutManager(new GridLayoutManager(this,3));
        gridMovieAdapter = new GridMovieAdapter(this);
        gridMovieAdapter.setMovies(movies);
        rvMovie.setAdapter(gridMovieAdapter);
    }

    private void loadData() {
        new MovieAsyncTask().execute();
    }

    public class MovieAsyncTask extends AsyncTask<Void, Void, Cursor> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            rvMovie.setVisibility(View.GONE);
            pbMovie.setVisibility(View.VISIBLE);
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            return getContentResolver().query(CONTENT_URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            rvMovie.setVisibility(View.VISIBLE);
            pbMovie.setVisibility(View.GONE);

            movies = mapCursorToArrayList(cursor);
            gridMovieAdapter.setMovies(movies);
        }
    }
}
