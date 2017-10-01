package com.tomek.view.movie;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;
import com.tomek.util.PanelsManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MovieUpdate extends JPanel {
    private Movie movie;

    private JLabel labTitle;
    private JLabel labDuration;
    private JLabel labDirector;
    private JLabel labYear;

    private JTextField tfTitle;
    private JTextField tfDuration;
    private JTextField tfDirector;
    private JTextField tfYear;

    private JButton btnSave;
    private JButton btnCancel;

    MovieUpdate(Movie movie) {
        super();

        this.movie = movie;

        labTitle = new JLabel("Title");
        tfTitle = new JTextField(movie.getTitle());

        labDuration = new JLabel("Duration");
        tfDuration = new JTextField(movie.getDuration());

        labDirector = new JLabel("Director");
        tfDirector = new JTextField(movie.getDirector());

        labYear = new JLabel("Year");
        tfYear = new JTextField(movie.getYear());

        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");

        initView();
    }

    void setTitle(String title) {
        this.tfTitle.setText(title);
    }

    public String getTitle() {
        return this.tfTitle.getText();
    }

    void setDuration(String duration) {
        this.tfDuration.setText(duration);
    }

    void setDirector(String director) {
        this.tfDirector.setText(director);
    }

    public void setYear(String year) {
        this.tfYear.setText(year);
    }

    private void initView() {
        setLayout(new MigLayout("fillx"));

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
            movie.setTitle(tfTitle.getText());
            movie.setDuration(Integer.valueOf(tfDuration.getText()));
            movie.setYear(Integer.valueOf(tfYear.getText()));
            movie.setDirector(tfDirector.getText());

            MovieDAO dao = new MovieDAO();
            dao.updateMovie(movie);

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            PanelsManager.changePanel(frame, new MovieList());
        });

        btnCancel.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            PanelsManager.changePanel(frame, new MovieList());
        });
    }
}
