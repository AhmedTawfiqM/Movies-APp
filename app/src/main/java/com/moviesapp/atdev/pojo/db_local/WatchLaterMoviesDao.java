package com.moviesapp.atdev.pojo.db_local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WatchLaterMoviesDao {

    @Insert
    void insertMovie(MovieEntity movie);

    @Delete
    void deleteMovie(MovieEntity movie);

    @Query("SELECT * FROM watchLater_table ORDER BY mId ASC")
    LiveData<List<MovieEntity>> getAllMovies();
}
