/*
 * @file : PopularAdapter.java
 * @brief : adapter class for recyclerview
 * @author : Praveen John
 */
package com.example.praveen.movieupdates.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.praveen.movieupdates.R;
import com.example.praveen.movieupdates.activities.MovieActivity;
import com.example.praveen.movieupdates.fragments.PopularMovieDetailsFragment;
import com.example.praveen.movieupdates.data.PopularMovData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.praveen.movieupdates.data.PopularMovieConstants.CLICKED_DATA;
import static com.example.praveen.movieupdates.data.PopularMovieConstants.IMAGE_URI;
import static com.example.praveen.movieupdates.data.PopularMovieConstants.MOVIE_DETAILS_FRAGMENT_TAG;


public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    /**
     * Variable to store ArrayList
     */
    private final ArrayList<PopularMovData> values;
    /**
     * Variable to store context
     */
    public Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         * Variable to store poster image
         */
        public ImageView posterImage;
        /**
         * Variable to store card view item
         */
        public CardView singlePopularItem;
        /**
         * Variable to view
         */
        public View layout;

        /**
         * @brief Viewholder
         * @param v : View
         */
        public ViewHolder(View v) {
            super(v);
            layout = v;
            posterImage = v.findViewById(R.id.image_poster);
            singlePopularItem = v.findViewById(R.id.singlepopularItem);
            singlePopularItem.setOnClickListener(this);
        }

        /**
         * @brief click listener for item position
         * @param v : View
         */
        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            PopularMovieDetailsFragment movieDetailsFragment = new PopularMovieDetailsFragment();
            Bundle args = new Bundle();
            args.putSerializable(CLICKED_DATA, values.get(pos));
            movieDetailsFragment.setArguments(args);
            ((MovieActivity) mContext).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, movieDetailsFragment, MOVIE_DETAILS_FRAGMENT_TAG).addToBackStack(null).commit();
        }
    }

    /**
     * @brief Constructor
     * @param myDataset : arraylist of values
     * @param context : Context
     */
    public PopularAdapter(ArrayList<PopularMovData> myDataset, Context context) {
        values = myDataset;
        mContext = context;
    }

    /**
     * @brief ViewHolder of adapter
     * @param parent : parent of the view
     * @param viewType : View type
     */
    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.popular_recycler_items, parent, false);
        return new ViewHolder(v);
    }

    /**
     * @brief bind method of view holder
     * @param holder : view holder
     * @param position : Position in the adapter
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String mImagePath = values.get(position).getmBackDropPath();
        Picasso.with(mContext).load(IMAGE_URI + mImagePath).into(holder.posterImage);
    }

    /**
     * @brief To get the array count
     * @return int: returns the array size
     */
    @Override
    public int getItemCount() {
        return values.size();
    }

}
