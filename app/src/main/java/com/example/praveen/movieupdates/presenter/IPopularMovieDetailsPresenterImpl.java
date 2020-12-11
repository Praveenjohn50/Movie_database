package com.example.praveen.movieupdates.presenter;

import android.content.Context;

import com.example.praveen.movieupdates.model.IPopularMovieDetailsModel;
import com.example.praveen.movieupdates.model.PopularMovieDetailsModelImpl;
import com.example.praveen.movieupdates.view.IPopularMovieDetailsView;

public class IPopularMovieDetailsPresenterImpl implements IPopularMovieDetailsPresenter {

    IPopularMovieDetailsModel mPopularMovieModel;
    IPopularMovieDetailsView mPopularMovieView;

    public IPopularMovieDetailsPresenterImpl(IPopularMovieDetailsView popularMovieView) {
        mPopularMovieModel = new PopularMovieDetailsModelImpl(this);
        if (popularMovieView != null) {
            mPopularMovieView = popularMovieView;
        }

    }
    @Override
    public void initialize(Context context) {
        mPopularMovieModel.initialize(context);

    }

    @Override
    public void sendRating(Float rating, int id) {
        mPopularMovieModel.sendRating(rating, id);

    }
}
