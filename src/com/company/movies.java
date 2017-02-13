package com.company;

/**
 * Created by simon blank on 2016-12-14.
 */
public class movies {
    private String name;
    private String genre;
    private int rating;
    private String type;


    public movies(String name, String genre, int rating, String type) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    public String getType() {
        return type;
    }
}
