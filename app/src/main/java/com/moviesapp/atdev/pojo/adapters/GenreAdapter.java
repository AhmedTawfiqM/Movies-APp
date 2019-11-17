package com.moviesapp.atdev.pojo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.moviesapp.atdev.R;
import com.moviesapp.atdev.databinding.GenreDataBinding;
import com.moviesapp.atdev.pojo.models.Genre;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.genreHolder> {

    private Context context;
    private List<Genre> genresList;

    public GenreAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public genreHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        GenreDataBinding genreDataBinding =
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.genre_item, viewGroup, false);
        return new genreHolder(genreDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull genreHolder genreHolder, int i) {
        Genre genre = genresList.get(i);
        if(genre != null) {
            genreHolder.bindGenres(genre);
        }
    }

    @Override
    public int getItemCount() {
        return genresList!=null?genresList.size():0;
    }

    public void setData(List<Genre> genresList) {
        this.genresList = genresList;
    }

    class genreHolder extends RecyclerView.ViewHolder{
        GenreDataBinding genreDataBinding;
        genreHolder(GenreDataBinding genreDataBinding) {
            super(genreDataBinding.getRoot());
            this.genreDataBinding = genreDataBinding;
        }

        void bindGenres(Genre genre) {

            genreDataBinding.setMovieGenres(genre);
        }
    }
}
