package com.moviesapp.atdev.pojo.repos;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.moviesapp.atdev.pojo.db_local.MovieEntity;
import com.moviesapp.atdev.pojo.db_local.WatchLaterMoviesDao;
import com.moviesapp.atdev.pojo.db_local.WatchLaterMoviesDataBase;

import java.util.List;

public class WatchLaterMoviesRepository {

    private WatchLaterMoviesDao movieDao;
    private LiveData<List<MovieEntity>> allMovies;

    public WatchLaterMoviesRepository(Application application){
        WatchLaterMoviesDataBase movieDataBase = WatchLaterMoviesDataBase.getInstance(application);
        movieDao = movieDataBase.movieDao();
        allMovies = movieDao.getAllMovies();
    }

    public void insert(MovieEntity movie){
        new InsertMovieAsyncTask(movieDao).execute(movie);
    }

    public void delete(MovieEntity movie){
        new DeleteMovieAsyncTask(movieDao).execute(movie);
    }

    public LiveData<List<MovieEntity>> getAllMovies() {
        return allMovies;
    }


    private static class InsertMovieAsyncTask extends AsyncTask<MovieEntity,Void,Void>{
        private WatchLaterMoviesDao movieDao;
        InsertMovieAsyncTask(WatchLaterMoviesDao movieDao){
            this.movieDao = movieDao;
        }
        @Override
        protected Void doInBackground(MovieEntity... movies) {
            movieDao.insertMovie(movies[0]);
            return null;
        }
    }

    private static class DeleteMovieAsyncTask extends AsyncTask<MovieEntity,Void,Void>{
        private WatchLaterMoviesDao movieDao;
        DeleteMovieAsyncTask(WatchLaterMoviesDao movieDao){
            this.movieDao = movieDao;
        }
        @Override
        protected Void doInBackground(MovieEntity... movies) {
            movieDao.deleteMovie(movies[0]);
            return null;
        }
    }
}
