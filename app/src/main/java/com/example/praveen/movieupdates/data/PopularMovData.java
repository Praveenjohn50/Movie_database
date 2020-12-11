/*
 * @file : PopularMovData.java
 * @brief : Json response object
 * @author : Praveen John
 */
package com.example.praveen.movieupdates.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PopularMovData implements Serializable {

    /**
     * Variable for isAdult
     */
    @SerializedName("adult")
    boolean isAdult;
    /**
     * Variable for mBackDropPath
     */
    @SerializedName("backdrop_path")
    String mBackDropPath;
    /**
     * Variable for the mGenre
     */
    @SerializedName("genre_ids")
    int [] mGenre;
    /**
     * Variable for the id
     */
    @SerializedName("id")
    int id;
    /**
     * Variable for the mLanguage
     */
    @SerializedName("original_language")
    String mLanguage;
    /**
     * Variable for the mOriginalTitle
     */
    @SerializedName("original_title")
    String mOriginalTitle;
    /**
     * Variable for the mOverview
     */
    @SerializedName("overview")
    String mOverview;
    /**
     * Variable for the mPopularity
     */
    @SerializedName("popularity")
    float mPopularity;
    /**
     * Variable for the mPosterPath
     */
    @SerializedName("poster_path")
    String mPosterPath;
    /**
     * Variable for the mReleaseDate
     */
    @SerializedName("release_date")
    String mReleaseDate;
    /**
     * Variable for the mTitle
     */
    @SerializedName("title")
    String mTitle;
    /**
     * Variable for the isVideo
     */
    @SerializedName("video")
    boolean isVideo;
    /**
     * Variable for the mVoteAverage
     */
    @SerializedName("vote_average")
    float mVoteAverage;
    /**
     * Variable for the mVoteCount
     */
    @SerializedName("vote_count")
    int mVoteCount;


    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getmBackDropPath() {
        return mBackDropPath;
    }

    public void setmBackDropPath(String mBackDropPath) {
        this.mBackDropPath = mBackDropPath;
    }

    public int[] getmGenre() {
        return mGenre;
    }

    public void setmGenre(int[] mGenre) {
        this.mGenre = mGenre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getmOriginalTitle() {
        return mOriginalTitle;
    }


    public String getmOverview() {
        return mOverview;
    }


    public String getmPosterPath() {
        return mPosterPath;
    }


    public float getmVoteAverage() {
        return mVoteAverage;
    }

    public String getmTitle() {
        return mTitle;
    }

}
