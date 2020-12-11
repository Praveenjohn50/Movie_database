package com.example.praveen.movieupdates.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.praveen.movieupdates.presenter.IPopularMoviePresenter;
import com.example.praveen.movieupdates.data.JSONResponse;
import com.example.praveen.movieupdates.data.PopularMovData;
import com.example.praveen.movieupdates.utilities.RequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PopularMovieModelImpl implements IPopularMovieModel {
    private IPopularMoviePresenter mPopularMoviePresenter;
    private ArrayList<PopularMovData> data;
    public Context mcontext;
    private final String BASE_URL = "https://api.themoviedb.org/3/";

    public PopularMovieModelImpl(IPopularMoviePresenter popularMoviePresenter) {
        if (popularMoviePresenter != null) {
            mPopularMoviePresenter = popularMoviePresenter;
        }

    }

    @Override
    public void initialize(Context context) {
        mcontext = context;
    }

    @Override
    public void loadApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                if (jsonResponse != null) {
                    data = new ArrayList<>(Arrays.asList(jsonResponse.getMovData()));
                    mPopularMoviePresenter.onResponse(data);
                }

            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Log.d("Error", t.getCause().toString());
            }
        });

    }

    @Override
    public boolean isOnline() {
        return isNetworkAvailable();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mcontext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
