package com.moviesapp.atdev.pojo.paging;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;

public class MoviesDataSourceFactory extends DataSource.Factory {

    MovieDataSource movieDataSource;
    String category;

    public MoviesDataSourceFactory(String category) {
        this.category = category;
    }

    @NonNull
    @Override
    public DataSource create() {

        if (movieDataSource == null) {
            movieDataSource = new MovieDataSource(category);
        }
        return movieDataSource;
    }
}
