package org.example.iocexam.config;

import org.example.iocexam.controller.MovieController;
import org.example.iocexam.dao.MovieDao;
import org.example.iocexam.dao.MovieDaoImpl;
import org.example.iocexam.service.MovieService;
import org.example.iocexam.service.MovieServiceImpl;
import org.springframework.context.annotation.Bean;

public class MovieConfig {
    @Bean
    public MovieDao movieDao(){
        return new MovieDaoImpl();
    }

    @Bean
    public MovieService movieService(MovieDao movieDao){
        return new MovieServiceImpl(movieDao);
    }

    @Bean
    public MovieController movieController(MovieService movieService){
        return new MovieController(movieService);
    }
}
