package com.example.praveen.movieupdates.model;

import android.content.Context;
import android.util.Log;

import com.example.praveen.movieupdates.presenter.IPopularMovieDetailsPresenter;
import com.example.praveen.movieupdates.data.RatingData;
import com.example.praveen.movieupdates.utilities.RequestInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;
import static com.example.praveen.movieupdates.data.PopularMovieConstants.RATING_POST;

public class PopularMovieDetailsModelImpl implements IPopularMovieDetailsModel {
    IPopularMovieDetailsPresenter movieDetailsPresenter;
    Context mContext;

    public PopularMovieDetailsModelImpl(IPopularMovieDetailsPresenter popularMoviePresenter) {
        if(popularMoviePresenter != null) {
            movieDetailsPresenter = popularMoviePresenter;
        }

    }
    @Override
    public void initialize(Context context) {
        mContext = context;

    }

    @Override
    public void sendRating(Float rating, int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RATING_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        RatingData rating1 = new RatingData(rating);
        request.sendRating(rating1).enqueue(new Callback<RatingData>() {
            @Override
            public void onResponse(Call<RatingData> call, Response<RatingData> response) {
                Log.d(TAG, "onResponse: "+response.toString());
            }

            @Override
            public void onFailure(Call<RatingData> call, Throwable t) {

            }
        });



    }
}
