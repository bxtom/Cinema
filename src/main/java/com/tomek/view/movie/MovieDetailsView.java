package com.tomek.view.movie;

import com.tomek.presenter.MoviePresenter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MovieDetailsView extends JPanel{

    private JLabel movieTitle;
    private JLabel movieDuration;
    private JLabel movieDirector;
    private JLabel movieYear;

    public MovieDetailsView() {
        init();
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle.setText("Title: " + movieTitle);
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration.setText("Duration: " + movieDuration);
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector.setText("Director: " + movieDirector);
    }

    public void setMovieYear(String movieYear) {
        this.movieYear.setText("Year: " + movieYear);
    }

    private void init() {
        this.setLayout(new MigLayout());

        movieTitle = new JLabel();
        movieDuration = new JLabel();
        movieDirector = new JLabel();
        movieYear = new JLabel();

        add(movieTitle, "wrap");
        add(movieDuration, "wrap");
        add(movieDirector, "wrap");
        add(movieYear, "wrap");

        JButton btnBack = new JButton("Back");
        add(btnBack);

        btnBack.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            MoviePresenter presenter = new MoviePresenter();
            presenter.setFrame(frame);
            presenter.showListOfMoviesView();
        });
    }
}
