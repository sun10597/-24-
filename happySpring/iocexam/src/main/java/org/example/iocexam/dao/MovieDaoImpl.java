package org.example.iocexam.dao;

import org.example.iocexam.domain.Movie;

public class MovieDaoImpl implements MovieDao{
    @Override
    public void addMovie(Movie movie) {
        System.out.println(movie.getTitle() + "가 추가되었습니다.");
    }


}
