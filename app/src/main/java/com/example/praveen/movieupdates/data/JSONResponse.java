/*
 * @file : JSONResponse.java
 * @brief : Json response object
 * @author : Praveen John
 */
package com.example.praveen.movieupdates.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class JSONResponse implements Serializable {

    /**
     * Variable for the array
     */
    @SerializedName("results")
    private PopularMovData[] movData;

    /**
     * @brief get method for the array
     * @return PopularMovData[] ; array list
     */
    public PopularMovData[] getMovData() {
        return movData;
    }
}