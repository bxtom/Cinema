package com.tomek.view;

import com.tomek.presenter.MoviePresenter;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(430, 300);
        setTitle("Cinema");
        setVisible(true);

        MoviePresenter presenter = new MoviePresenter();
        presenter.setFrame(this);
        presenter.showListOfMoviesView();
    }
}
