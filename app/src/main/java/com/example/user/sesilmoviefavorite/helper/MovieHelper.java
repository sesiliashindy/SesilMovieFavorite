package com.example.user.sesilmoviefavorite.helper;

import android.database.Cursor;

import com.example.user.sesilmoviefavorite.model.MovieFavorite;

import java.util.ArrayList;
import java.util.Date;

public class MovieHelper {
    private static final String ID = "id";
    private static final String NAME = "original_title";
    private static final String POSTER = "poster";
    private static final String OVERVIEW = "overview";
    private static final String LANGUAGE = "original_language";
    private static final String DATE = "release_date";
    private static final String VOTE = "vote_average";

    public static ArrayList<MovieFavorite> mapCursorToArrayList(Cursor notesCursor){
        ArrayList<MovieFavorite> movies = new ArrayList<>();

        while (notesCursor.moveToNext()){
            String id = notesCursor.getString(notesCursor.getColumnIndexOrThrow(ID));
            String name = notesCursor.getString(notesCursor.getColumnIndexOrThrow(NAME));
            String poster = notesCursor.getString(notesCursor.getColumnIndexOrThrow(POSTER));
            String overview = notesCursor.getString(notesCursor.getColumnIndexOrThrow(OVERVIEW));
            String languange = notesCursor.getString(notesCursor.getColumnIndexOrThrow(LANGUAGE));
            String date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DATE));
            int vote = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(VOTE));
            movies.add(new MovieFavorite(id,name,poster,overview,languange,date,vote));
        }
        return movies;
    }
}
