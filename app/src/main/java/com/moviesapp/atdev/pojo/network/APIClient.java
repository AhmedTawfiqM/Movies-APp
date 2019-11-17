package com.moviesapp.atdev.pojo.network;

import com.moviesapp.atdev.pojo.models.CreditResponse;
import com.moviesapp.atdev.pojo.models.DetailsResponse;
import com.moviesapp.atdev.pojo.models.MovieResponse;
import com.moviesapp.atdev.pojo.models.MovieVideos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIClient {

    //All Movies
    @GET("/3/movie/{category}?")
    Call<MovieResponse> getMovies(@Path("category") String category, @Query("page") int Page);

    //movie credit
    @GET("/3/movie/{movie_id}/credits?")
    Call<CreditResponse> getMovieCreditsResponse(@Path("movie_id") Integer movieId);

    //movie detail
    @GET("/3/movie/{movie_id}?")
    Call<DetailsResponse> getMovieDetails(@Path("movie_id") Integer movieId);

    //recommendations
    @GET("/3/movie/{movie_id}/recommendations?")
    Call<MovieResponse> getRecommendationResponse(@Path("movie_id") Integer movieId);

    //similar
    @GET("/3/movie/{movie_id}/similar?")
    Call<MovieResponse> getSimilarResponse(@Path("movie_id") Integer movieId);

    //movie videos
    @GET("/3/movie/{movie_id}/videos?")
    Call<MovieVideos> getMovieVideosResponse(@Path("movie_id") Integer movieId);


}
