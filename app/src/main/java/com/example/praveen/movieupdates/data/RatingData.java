/*
 * @file : RatingData.java
 * @brief : Pojo class
 * @author : Praveen John
 */
package com.example.praveen.movieupdates.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RatingData implements Serializable {
    public RatingData(Float rating) {
        this.rating = rating;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @SerializedName("value")
    Float rating;
}
