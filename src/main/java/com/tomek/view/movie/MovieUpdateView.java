package com.tomek.view.movie;

import com.tomek.entity.Movie;
import com.tomek.presenter.MoviePresenter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MovieUpdateView extends JPanel {
    private Movie movie;

    private JTextField tfTitle;
    private JTextField tfDuration;
    private JTextField tfDirector;
    private JTextField tfYear;

    public MovieUpdateView(Movie movie) {
        this.movie = movie;

        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx"));

        JLabel labTitle = new JLabel("Title");
        tfTitle = new JTextField(movie.getTitle());

        JLabel labDirector = new JLabel("Director");
        tfDirector = new JTextField(movie.getDirector());

        JLabel labDuration = new JLabel("Duration");
        tfDuration = new JTextField(String.valueOf(movie.getDuration()));

        JLabel labYear = new JLabel("Year");
        tfYear = new JTextField(String.valueOf(movie.getYear()));

        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");


        add(labTitle, "wrap");
        add(tfTitle, "wrap, growx");

        add(labDirector, "wrap");
        add(tfDirector, "wrap, growx");

        add(labDuration, "wrap");
        add(tfDuration, "wrap, growx");

        add(labYear, "wrap");
        add(tfYear, "wrap, growx");

        add(btnSave, "split");
        add(btnCancel, "wrap");


        btnSave.addActionListener(e -> {
            movie.setTitle(tfTitle.getText());
            movie.setDirector(tfDirector.getText());
            movie.setDuration(Integer.valueOf(tfDuration.getText()));
            movie.setYear(Integer.valueOf(tfYear.getText()));

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            MoviePresenter presenter = new MoviePresenter();
            presenter.setFrame(frame);
            presenter.updateMovie(movie);
            presenter.showListOfMoviesView();
        });

        btnCancel.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            MoviePresenter presenter = new MoviePresenter();
            presenter.setFrame(frame);
            presenter.showListOfMoviesView();
        });
    }
}
