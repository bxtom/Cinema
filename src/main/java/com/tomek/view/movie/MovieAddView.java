package com.tomek.view.movie;

import com.tomek.entity.Movie;
import com.tomek.presenter.MoviePresenter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MovieAddView extends JPanel {

    private JTextField tfTitle;
    private JTextField tfDuration;
    private JTextField tfDirector;
    private JTextField tfYear;

    public MovieAddView() {
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx"));


        JLabel labTitle = new JLabel("Title");
        tfTitle = new JTextField();

        JLabel labDuration = new JLabel("Duration");
        tfDuration = new JTextField();

        JLabel labDirector = new JLabel("Director");
        tfDirector = new JTextField();

        JLabel labYear = new JLabel("Year");
        tfYear = new JTextField();

        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");


        add(labTitle, "wrap");
        add(tfTitle, "wrap, growx");

        add(labDuration, "wrap");
        add(tfDuration, "wrap, growx");

        add(labDirector, "wrap");
        add(tfDirector, "wrap, growx");

        add(labYear, "wrap");
        add(tfYear, "wrap, growx");

        add(btnSave, "split");
        add(btnCancel, "wrap");

        btnSave.addActionListener(e -> {
            Movie movie = new Movie();
            movie.setTitle(tfTitle.getText());
            movie.setDuration(Integer.valueOf(tfDuration.getText()));
            movie.setYear(Integer.valueOf(tfYear.getText()));
            movie.setDirector(tfDirector.getText());

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            MoviePresenter presenter = new MoviePresenter();
            presenter.setFrame(frame);
            presenter.saveMovie(movie);
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
