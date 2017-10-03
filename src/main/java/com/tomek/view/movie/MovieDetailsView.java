package com.tomek.view.movie;

import com.tomek.entity.Movie;
import com.tomek.util.PanelsManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MovieDetailsView extends JPanel{

    private JLabel labTitle;
    private JLabel labDuration;
    private JLabel labDirector;
    private JLabel labYear;

    public MovieDetailsView() {
        init();
    }

    public void setLabTitle(String movieTitleText) {
        labTitle.setText("Title: " + movieTitleText);
    }

    public void setLabDuration(String duration) {
        labDuration.setText("Duration: " + duration);
    }

    public void setLabDirector(String directorText) {
        this.labDirector.setText("Director: " + directorText);
    }

    public void setLabYear(String yearText) {
        this.labYear.setText("Year: " + yearText);
    }

    private void init() {
        this.setLayout(new MigLayout());

        labTitle = new JLabel();
        labDuration = new JLabel();
        labDirector = new JLabel();
        labYear = new JLabel();

        add(labTitle, "wrap");
        add(labDuration, "wrap");
        add(labDirector, "wrap");
        add(labYear, "wrap");

        JButton btnBack = new JButton("Back");
        add(btnBack);

        btnBack.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            PanelsManager.changePanel(frame, new MovieListView());
        });
    }
}
