/*
 * @file : PopularMoviesFragment.java
 * @brief : PopularMoviesFragment implementation
 * @author : Praveen John
 */
package com.example.praveen.movieupdates.fragments;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.praveen.movieupdates.R;
import com.example.praveen.movieupdates.adapters.PopularAdapter;
import com.example.praveen.movieupdates.dialog.CustomDialogClass;
import com.example.praveen.movieupdates.presenter.IPopularMoviePresenter;
import com.example.praveen.movieupdates.presenter.PopularMoviePresenterImpl;
import com.example.praveen.movieupdates.utilities.DotsIndicatorDecoration;
import com.example.praveen.movieupdates.data.PopularMovData;
import com.example.praveen.movieupdates.view.IPopularMovieView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


public class PopularMoviesFragment extends Fragment implements IPopularMovieView {

    /**
     * Variable for mView
     */
    View mView;
    /**
     * Variable for mPopularMovePresenter
     */
    IPopularMoviePresenter mPopularMovePresenter;
    /**
     * Variable for recyclerView
     */
    private RecyclerView recyclerView;
    /**
     * Variable for mAdapter
     */
    private RecyclerView.Adapter mAdapter;
    /**
     * Variable for layoutManager
     */
    private RecyclerView.LayoutManager layoutManager;
    /**
     * Variable for progress bar
     */
    public ProgressDialog p;
    /**
     * Variable for mPopularMovData
     */
    public ArrayList<PopularMovData> mPopularMovData;
    /**
     * Variable for moviesFragment
     */
    public PopularMoviesFragment moviesFragment;
    /**
     * Variable for Custom dialog
     */
    public CustomDialogClass cdd;


    /**
     * @brief  on create view method
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPopularMovePresenter = new PopularMoviePresenterImpl(this);
        mView = inflater.inflate(R.layout.fragment_popular_movie, container, false);
        mPopularMovePresenter.initialize(getContext());
        return mView;
    }

    /**
     * @brief  on view created  method
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SnapHelper snapHelper = new PagerSnapHelper();
        moviesFragment = new PopularMoviesFragment();
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        cdd = new CustomDialogClass(getActivity(), moviesFragment);
        cdd.setCancelable(false);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        snapHelper.attachToRecyclerView(recyclerView);
        final int radius = getResources().getDimensionPixelSize(R.dimen.radius);
        final int dotsHeight = getResources().getDimensionPixelSize(R.dimen.dots_height);
        final int color = ContextCompat.getColor(getContext(), R.color.dot_color);
        recyclerView.addItemDecoration(new DotsIndicatorDecoration(radius, radius * 4, dotsHeight, color, color));
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        if(isOnline()) {
            AsynkLoadApi asynkLoadApi = new AsynkLoadApi();
            asynkLoadApi.execute();
        } else {
            cdd.show();
        }

    }

    /**
     * @brief  on response method
     * @param  popularMovData : An array list
     */
    @Override
    public void onResponse(ArrayList<PopularMovData> popularMovData) {
        mPopularMovData = popularMovData;
        mAdapter = new PopularAdapter(popularMovData, getContext());
        recyclerView.setAdapter(mAdapter);
    }

    private class AsynkLoadApi extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p = new ProgressDialog(getContext());
            p.setMessage("Downloading");
            p.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            mPopularMovePresenter.loadApi();
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            p.hide();
        }
    }

    public boolean isOnline() {
       return mPopularMovePresenter.isOnline();
    }
}
