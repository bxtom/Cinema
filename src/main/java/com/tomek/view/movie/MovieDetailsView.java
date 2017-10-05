package com.tomek.view.movie;

import com.tomek.entity.Movie;
import com.tomek.presenter.MoviePresenter;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MovieDetailsView extends JPanel{
    private Movie movie;

    public MovieDetailsView(Movie movie) {
        this.movie = movie;

        init();
    }

    private void init() {
        this.setLayout(new MigLayout());

        JLabel movieTitle = new JLabel("Title: " + movie.getTitle());
        JLabel movieDirector = new JLabel("Director: " + movie.getDirector());
        JLabel movieDuration = new JLabel("Duration: " + String.valueOf(movie.getDuration()));
        JLabel movieYear = new JLabel("Year: " + String.valueOf(movie.getYear()));

        add(movieTitle, "wrap");
        add(movieDirector, "wrap");
        add(movieDuration, "wrap");
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
