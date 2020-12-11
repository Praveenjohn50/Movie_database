package com.example.praveen.movieupdates.view;

import com.example.praveen.movieupdates.data.PopularMovData;

import java.util.ArrayList;

public interface IPopularMovieView {

    void onResponse(ArrayList<PopularMovData> popularMovData);
}
