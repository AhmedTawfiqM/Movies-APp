package com.moviesapp.atdev.pojo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.moviesapp.atdev.R;
import com.moviesapp.atdev.databinding.MovieDataBinding;
import com.moviesapp.atdev.pojo.models.Movie;
import com.moviesapp.atdev.utils.ClickListener;

import java.util.List;

public class SimilarMovieAdapter extends RecyclerView.Adapter<SimilarMovieAdapter.similarHolder>  {

    private static ClickListener clickListener;
    private Context context;
    private List<Movie> moviesList;

    public SimilarMovieAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public similarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MovieDataBinding movieDataBinding =
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.movie_item, parent, false);
        return new similarHolder(movieDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull similarHolder holder, int position) {
        Movie movie = moviesList.get(position);

        if(movie != null){
            holder.bindMovie(movie);
        }

    }

    @Override
    public int getItemCount() {
        return moviesList!=null? moviesList.size():0;
    }

    public void setData(List<Movie> movieList) {
        this.moviesList = movieList;
    }


    class similarHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        MovieDataBinding movieDataBinding;

        similarHolder(MovieDataBinding movieDataBinding) {
            super(movieDataBinding.getRoot());
            this.movieDataBinding = movieDataBinding;
            itemView.setOnClickListener(this);
        }

        void bindMovie(Movie movie) {

            movieDataBinding.setMovie(movie);
        }

        @Override
        public void onClick(View v) {
            clickListener.OnItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        SimilarMovieAdapter.clickListener = clickListener;
    }

}
