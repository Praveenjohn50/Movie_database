package com.example.praveen.movieupdates.presenter;

import android.content.Context;

import com.example.praveen.movieupdates.data.PopularMovData;

import java.util.ArrayList;

public interface IPopularMoviePresenter {

    void initialize(Context context);

    void loadApi();

    boolean isOnline();

    void onResponse(ArrayList<PopularMovData> popularMovData);
}
