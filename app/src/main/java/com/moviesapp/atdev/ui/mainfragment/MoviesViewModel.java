package com.moviesapp.atdev.ui.mainfragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.moviesapp.atdev.pojo.models.Movie;
import com.moviesapp.atdev.pojo.paging.MovieDataSource;
import com.moviesapp.atdev.pojo.paging.MoviesDataSourceFactory;
import com.moviesapp.atdev.utils.Constants;

public class MoviesViewModel extends ViewModel {

    private LiveData liveData = null;
    private PagedList.Config config;


    public MoviesViewModel() {
        config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(Constants.PAGE_SIZE)
                .build();
    }

    public LiveData<PagedList<Movie>> getMovies(String category) {

        if (liveData == null) {
            MoviesDataSourceFactory moviesDataSource = new MoviesDataSourceFactory(category);
            liveData = new LivePagedListBuilder<>(moviesDataSource, config).build();
        }
        return liveData;
    }
}
