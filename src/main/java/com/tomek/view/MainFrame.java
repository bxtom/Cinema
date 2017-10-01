package com.tomek.view;

import com.tomek.entity.dao.MovieDAO;
import com.tomek.view.movie.MovieAdd;
import com.tomek.view.movie.MovieList;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
//    MovieDetails movieDetails;
//    MoviePresenter moviePresenter;

    MovieList movieList;

    public MainFrame() throws HeadlessException {
//        movieDetails = new MovieDetails();
//        moviePresenter = new MoviePresenter(movieDetails);

        //movieList = new MovieList();

        initView();
    }

    private void initView() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(430, 600);
        setTitle("Cinema");
        //setContentPane(movieDetails);
        //setContentPane(movieList);

        MovieDAO movieDAO = new MovieDAO();
        MovieList movies = new MovieList();
        //movies.setMoviesList(movieDAO.getMovieList());
        setContentPane(movies);
        //setContentPane(new MovieAdd());
        setVisible(true);
        //moviePresenter.showMovie(1);
        //moviesListPresenter.showMoviesList();
    }

    public void changeToAddMovieView() {
        getContentPane().removeAll();
        getContentPane().add(new MovieAdd());
        revalidate();
    }

    private void changeToMovieView() {

    }
}
