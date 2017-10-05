package com.tomek.presenter;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;
import com.tomek.view.movie.MovieAddView;
import com.tomek.view.movie.MovieDetailsView;
import com.tomek.view.movie.MovieListView;
import com.tomek.view.movie.MovieUpdateView;

import javax.swing.*;

public class MoviePresenter {
    private JFrame frame;

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    private void changeView(JFrame frame, JPanel newPanel) {
        frame.setContentPane(newPanel);
        frame.invalidate();
        frame.validate();
    }

    public void showMovieDetailsView(Movie movie) {
        MovieDetailsView view = new MovieDetailsView(movie);
        changeView(frame, view);
    }

    public void showListOfMoviesView() {
        MovieListView view = new MovieListView();
        changeView(frame, view);
    }

    public void showMovieUpdateView(Movie movie) {
        MovieUpdateView view = new MovieUpdateView(movie);
        changeView(frame, view);
    }

    public void showMovieAddView() {
        MovieAddView view = new MovieAddView();
        changeView(frame, view);
    }

    public void removeMovie(Movie movie) {
        MovieDAO dao = new MovieDAO();
        dao.removeMovie(movie);
    }

    public void saveMovie(Movie movie) {
        MovieDAO dao = new MovieDAO();
        dao.saveMovie(movie);
    }

    public void updateMovie(Movie movie) {
        MovieDAO dao = new MovieDAO();
        dao.updateMovie(movie);
    }
}
