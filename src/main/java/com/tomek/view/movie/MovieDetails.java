package com.tomek.view.movie;

import javax.swing.*;

public class MovieDetails extends JPanel{

    private JLabel movieTitle;
    private JLabel movieDuration;
    private JLabel movieDirector;

    public MovieDetails() {
        super();
        movieTitle = new JLabel();
        movieDuration = new JLabel();
        movieDirector = new JLabel();
        initView();
    }

    public void setMovieTitle(String movieTitleText) {
        movieTitle.setText(movieTitleText);
    }

    public void setMOvieDuration(String duration) {
        movieDuration.setText(duration);
    }

    public void setMovieDirector(String directorText) {
        this.movieDirector.setText(directorText);
    }

    public void initView() {
        movieTitle.setBounds(30, 30, 500, 100);
        movieDuration.setBounds(30,130, 500,100);
        movieDirector.setBounds(30, 230,500,100);
        add(movieTitle);
        add(movieDuration);
        add(movieDirector);
    }
}
