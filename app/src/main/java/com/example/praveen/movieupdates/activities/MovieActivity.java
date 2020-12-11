/*
 * @file : MovieActivity.java
 * @brief : considered as MainActivity in this application
 * @author : Praveen John
*/
package com.example.praveen.movieupdates.activities;

import android.os.Bundle;

import com.example.praveen.movieupdates.R;
import com.example.praveen.movieupdates.fragments.PopularMoviesFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MovieActivity extends AppCompatActivity {
    /**
     * @brief : OnCreate Method called on activity creation
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        PopularMoviesFragment popularMoviesFragment = new PopularMoviesFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, popularMoviesFragment).commitAllowingStateLoss();
    }
}
