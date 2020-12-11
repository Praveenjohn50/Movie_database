package com.example.praveen.movieupdates.utilities;

import com.example.praveen.movieupdates.data.JSONResponse;
import com.example.praveen.movieupdates.data.RatingData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static com.example.praveen.movieupdates.data.PopularMovieConstants.API_KEY;

public interface RequestInterface {



    @GET("movie/popular?api_key="+API_KEY+"&language=en-US&page=1")
    Call<JSONResponse> getJSON();
    @POST("movie/590706/rating?api_key="+API_KEY)
    Call<RatingData> sendRating(@Body RatingData ratingData);
}