package com.moviesapp.atdev.pojo.network;

import com.moviesapp.atdev.pojo.models.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIClient {

    //All Movies
    @GET("/3/movie/{category}?")
    Call<MovieResponse> getMovies(@Path("category") String category, @Query("page") int Page);

}
