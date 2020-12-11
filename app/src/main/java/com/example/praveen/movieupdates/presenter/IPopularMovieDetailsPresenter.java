package com.example.praveen.movieupdates.presenter;

import android.content.Context;

public interface IPopularMovieDetailsPresenter {
    void initialize(Context context);
    void sendRating(Float rating, int id);
}
