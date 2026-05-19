package org.example.iocexam.controller;

import org.example.iocexam.domain.Movie;
import org.example.iocexam.service.MovieService;

public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    public void RegisterMoive(){
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("영화");
        movie.setDirector("kim");
        movie.setGenre("액션");

        movieService.registerMovie(movie);
    }
}
