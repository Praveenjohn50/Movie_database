/*
 * @file : PopularMovieDetailsFragment.java
 * @brief : Popular movie details fragment implementation
 * @author : Praveen John
 */
package com.example.praveen.movieupdates.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.praveen.movieupdates.R;
import com.example.praveen.movieupdates.presenter.IPopularMovieDetailsPresenter;
import com.example.praveen.movieupdates.presenter.IPopularMovieDetailsPresenterImpl;
import com.example.praveen.movieupdates.data.PopularMovData;
import com.example.praveen.movieupdates.view.IPopularMovieDetailsView;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.praveen.movieupdates.data.PopularMovieConstants.CLICKED_DATA;
import static com.example.praveen.movieupdates.data.PopularMovieConstants.IMAGE_URI;


public class PopularMovieDetailsFragment extends Fragment implements RatingBar.OnRatingBarChangeListener, IPopularMovieDetailsView {

    /**
     * Variable for mView
     */
    View mView;
    /**
     * Variable for mdetailImage
     */
    public ImageView mdetailImage;
    /**
     * Variable for mTopImage
     */
    public ImageView mTopImage;
    /**
     * Variable for mTitleImageIcon
     */
    public ImageView mTitleImageIcon;
    /**
     * Variable for mDetailTitile
     */
    public TextView mDetailTitile;
    /**
     * Variable for mDetailOverview
     */
    public TextView mDetailOverview;
    /**
     * Variable for mCurrentRating
     */
    public TextView mCurrentRating;
    /**
     * Variable for mVotes
     */
    public TextView mVotes;
    /**
     * Variable for movData
     */
    public PopularMovData movData;
    /**
     * Variable for mRatingBar
     */
    public RatingBar mRatingBar;
    /**
     * Variable for mPopularMovePresenter
     */
    IPopularMovieDetailsPresenter mPopularMovePresenter;

    /**
     * @brief on create view method
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPopularMovePresenter = new IPopularMovieDetailsPresenterImpl(this);
        mView = inflater.inflate(R.layout.popular_movie_details_fragment, container, false);
        mPopularMovePresenter.initialize(getContext());
        return mView;
    }

    /**
     * @brief on view created method
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            movData = (PopularMovData) bundle.getSerializable(CLICKED_DATA);
        }
        mdetailImage = view.findViewById(R.id.movie_image);
        mDetailTitile = view.findViewById(R.id.details_title);
        mDetailOverview = view.findViewById(R.id.details_overview);
        mTopImage = view.findViewById(R.id.poster_image);
        mRatingBar = view.findViewById(R.id.rating_bar);
        mCurrentRating = view.findViewById(R.id.current_rating);
        mTitleImageIcon = view.findViewById(R.id.movie_image_icon);
        mVotes = view.findViewById(R.id.vote_average);
        Picasso.with(getContext()).load(IMAGE_URI+movData.getmPosterPath()).into(mdetailImage);
        Picasso.with(getContext()).load(IMAGE_URI+movData.getmBackDropPath()).into(mTopImage);
        Picasso.with(getContext()).load(IMAGE_URI+movData.getmPosterPath()).into(mTitleImageIcon);
        mDetailTitile.setText(movData.getmTitle());
        mDetailOverview.setText(movData.getmOverview());
        mVotes.setText(String.valueOf(movData.getmVoteAverage()));
        mRatingBar.setOnRatingBarChangeListener(this);

    }

    /**
     * @brief on rating changed method
     */
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        mCurrentRating.setText(String.valueOf(rating));
        mPopularMovePresenter.sendRating(rating, movData.getId());
    }
}
