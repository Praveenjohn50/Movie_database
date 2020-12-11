package com.example.praveen.movieupdates.model;

import android.content.Context;

public interface IPopularMovieModel {

    void initialize(Context context);

    void loadApi();
    boolean isOnline();
}
