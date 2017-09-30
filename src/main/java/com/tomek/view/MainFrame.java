package com.tomek.view;

import com.tomek.presenter.MoviePresenter;
import com.tomek.view.movie.MovieAdd;
import com.tomek.view.movie.MovieDetails;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    MovieDetails movieDetails;
    MoviePresenter moviePresenter;

    public MainFrame() throws HeadlessException {
        movieDetails = new MovieDetails();
        moviePresenter = new MoviePresenter(movieDetails);
        initView();
    }

    private void initView() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 500);
        setContentPane(movieDetails);
        setVisible(true);
        moviePresenter.showMovie(1);
    }
}
