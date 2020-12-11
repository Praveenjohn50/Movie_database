package com.example.praveen.movieupdates.presenter;

import android.content.Context;

import com.example.praveen.movieupdates.model.IPopularMovieModel;
import com.example.praveen.movieupdates.model.PopularMovieModelImpl;
import com.example.praveen.movieupdates.data.PopularMovData;
import com.example.praveen.movieupdates.view.IPopularMovieView;

import java.util.ArrayList;

public class PopularMoviePresenterImpl implements IPopularMoviePresenter {

    IPopularMovieModel mPopularMovieModel;
    IPopularMovieView mPopularMovieView;


    public PopularMoviePresenterImpl(IPopularMovieView popularMovieView) {
        mPopularMovieModel = new PopularMovieModelImpl(this);
        if (popularMovieView != null) {
            mPopularMovieView = popularMovieView;
        }

    }

    @Override
    public void initialize(Context context) {
        mPopularMovieModel.initialize(context);

    }

    @Override
    public void loadApi() {
        mPopularMovieModel.loadApi();
    }

    @Override
    public boolean isOnline() {
        return mPopularMovieModel.isOnline();
    }

    @Override
    public void onResponse(ArrayList<PopularMovData> popularMovData) {
        mPopularMovieView.onResponse(popularMovData);
    }
}
