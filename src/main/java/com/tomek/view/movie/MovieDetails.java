package com.tomek.view.movie;

import com.tomek.util.PanelsManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MovieDetails extends JPanel{

    private JLabel movieTitle;
    private JLabel movieDuration;
    private JLabel movieDirector;
    private JLabel movieYear;
    private JButton btnBack;

    MovieDetails() {
        super();
        movieTitle = new JLabel();
        movieDuration = new JLabel();
        movieDirector = new JLabel();
        movieYear = new JLabel();
        btnBack = new JButton("Back");
        initView();
    }

    public void setMovieTitle(String movieTitleText) {
        movieTitle.setText("Title: " + movieTitleText);
    }

    public void setMovieDuration(String duration) {
        movieDuration.setText("Duration: " + duration);
    }

    public void setMovieDirector(String directorText) {
        this.movieDirector.setText("Director: " + directorText);
    }

    public void setMovieYear(String yearText) {
        this.movieYear.setText("Year: " + yearText);
    }

    private void initView() {
        this.setLayout(new MigLayout());

        btnBack.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            PanelsManager.changePanel(frame, new MovieList());
        });

        add(movieTitle, "wrap");
        add(movieDuration, "wrap");
        add(movieDirector, "wrap");
        add(movieYear, "wrap");
        add(btnBack);
    }
}
