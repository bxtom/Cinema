package com.tomek.presenter;

import com.tomek.entity.Movie;
import com.tomek.view.movie.MovieDetailsView;

public class MoviePresenter {

    private MovieDetailsView movieDetailsView;

    public MoviePresenter(MovieDetailsView movieDetailsView) {
        this.movieDetailsView = movieDetailsView;
    }

    public void showMovie(Movie movie) {
        MovieDetailsView details = new MovieDetailsView();
        details.setLabTitle(movie.getTitle());
        details.setLabDirector(movie.getDirector());
        details.setLabDuration("" + movie.getDuration());
    }

    public void addMovie() {

    }
}
