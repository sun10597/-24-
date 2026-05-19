package org.example.iocexam.service;
import org.example.iocexam.dao.MovieDao;
import org.example.iocexam.domain.Movie;


public class MovieServiceImpl implements MovieService{
    private MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao=movieDao;
    }

    @Override
    public void registerMovie(Movie movie) {
        if(movie.getTitle() == null || movie.getTitle().isEmpty()){
            throw new IllegalArgumentException("영화 제목은 필수 입력입니다.");
        }

//        Movie existMovie = movieDao.getMovieByTitle(movie.getTitle());
//        if(existMovie != null){
//            throw new IllegalArgumentException("이미 등록되어 있는 영화입니다.");
//        }

        movieDao.addMovie(movie);
    }
}
