
package com.moviesapp.atdev.pojo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieVideos {

    @SerializedName("results")
    @Expose
    private List<Videos> videos;

    public MovieVideos(List<Videos> videos) {
        this.videos = videos;
    }

    public List<Videos> getVideos() {
        return videos;
    }

}
