
package com.moviesapp.atdev.pojo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crew {


    @SerializedName("name")
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
