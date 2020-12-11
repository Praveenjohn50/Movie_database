/*
 * @file : IPopularMovieDetailsModel intrface
 * @brief : IPopularMovieDetailsModel implementation
 * @author : Praveen John
 */
package com.example.praveen.movieupdates.model;

import android.content.Context;

public interface IPopularMovieDetailsModel {
    /**
     * initialize
     */
    void initialize(Context context);
    /**
     * Post the rating
     */
    void sendRating(Float rating, int id);
}
