package com.tomek.view;

import com.tomek.entity.dao.MovieDAO;
import com.tomek.view.movie.MovieAddView;
import com.tomek.view.movie.MovieListView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
//    MovieDetailsView movieDetails;
//    MoviePresenter moviePresenter;

    MovieListView movieListView;

    public MainFrame() throws HeadlessException {
//        movieDetails = new MovieDetailsView();
//        moviePresenter = new MoviePresenter(movieDetails);

        //movieListView = new MovieListView();

        initView();
    }

    private void initView() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(430, 300);
        setTitle("Cinema");
        //setContentPane(movieDetails);
        //setContentPane(movieListView);

        MovieDAO movieDAO = new MovieDAO();
        MovieListView movies = new MovieListView();
        //movies.setMoviesList(movieDAO.getMovieList());
        setContentPane(movies);
        //setContentPane(new MovieAddView());
        setVisible(true);
        //moviePresenter.showMovie(1);
        //moviesListPresenter.showMoviesList();
    }

    public void changeToAddMovieView() {
        getContentPane().removeAll();
        getContentPane().add(new MovieAddView());
        revalidate();
    }

    private void changeToMovieView() {

    }
}
