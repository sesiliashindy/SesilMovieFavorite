package com.example.user.sesilmoviefavorite.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieFavorite implements Parcelable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String id;
    private String name;
    private String overview;
    private String poster;
    private int vote_average;
    private String date;
    private String language;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.overview);
        dest.writeString(this.poster);
        dest.writeInt(this.vote_average);
        dest.writeString(this.date);
        dest.writeString(this.language);
    }

    public MovieFavorite(String id, String name, String poster, String overview,String language, String date,int vote_average) {
        this.id = id;
        this.name = name;
        this.poster = poster;
        this.overview = overview;
        this.language = language;
        this.date = date;
        this.vote_average = vote_average;
    }

    protected MovieFavorite(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.overview = in.readString();
        this.poster = in.readString();
        this.vote_average = in.readInt();
        this.date = in.readString();
        this.language = in.readString();
    }

    public static final Parcelable.Creator<MovieFavorite> CREATOR = new Parcelable.Creator<MovieFavorite>() {
        @Override
        public MovieFavorite createFromParcel(Parcel source) {
            return new MovieFavorite(source);
        }

        @Override
        public MovieFavorite[] newArray(int size) {
            return new MovieFavorite[size];
        }
    };
}
