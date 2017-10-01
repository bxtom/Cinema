package com.tomek.presenter;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;
import com.tomek.view.movie.MovieDetails;

public class MoviePresenter {

    private MovieDAO movieDAO = new MovieDAO();
    private MovieDetails movieDetails;

    public MoviePresenter(MovieDetails movieDetails) {
        this.movieDetails = movieDetails;
    }

    public void showMovie(Integer movieID) {
        Movie movie = movieDAO.getMovie(movieID);
        movieDetails.setMovieTitle(movie.getTitle());
        movieDetails.setMovieDirector(movie.getDirector());
        movieDetails.setMovieDuration("" + movie.getDuration());
    }

    public void showMovie(Movie movie) {
        movieDetails.setMovieTitle(movie.getTitle());
        movieDetails.setMovieDirector(movie.getDirector());
        movieDetails.setMovieDuration("" + movie.getDuration());
    }

    public void addMovie() {

    }
}
