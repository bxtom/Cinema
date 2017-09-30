package com.tomek.view.movie;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class MovieAdd extends JPanel {
    private JLabel labTitle;
    private JLabel labDuration;
    private JLabel labDirector;
    private JLabel labYear;

    private JTextField tfTitle;
    private JTextField tfDuration;
    private JTextField tfDirector;
    private JTextField tfYear;

    private JButton btnSave;

    public MovieAdd() {
        labTitle = new JLabel("Title");
        tfTitle = new JTextField();

        labDuration = new JLabel("Duration");
        tfDuration = new JTextField();

        labDirector = new JLabel("Director");
        tfDirector = new JTextField();

        labYear = new JLabel("Year");
        tfYear = new JTextField();

        btnSave = new JButton("Save");
    }

    public void setTitle(String title) {
        this.tfTitle.setText(title);
    }

    public String getTitle() {
        return this.tfTitle.getText();
    }

    public void setDuration(String duration) {
        this.tfDuration.setText(duration);
    }

    public void setDirector(String director) {
        this.tfDirector.setText(director);
    }

    public void setYear(String year) {
        this.tfYear.setText(year);
    }

    public void initView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(labTitle);
        add(tfTitle);
        add(labDuration);
        add(tfDuration);
        add(labDirector);
        add(tfDirector);
        add(labYear);
        add(tfYear);
        add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie movie = new Movie();
                movie.setTitle(tfTitle.getText());
                movie.setDuration(Integer.valueOf(tfDuration.getText()));
                movie.setYear(Date.valueOf(tfYear.getText()));
                movie.setDirector(tfDirector.getText());

                MovieDAO dao = new MovieDAO();
                dao.saveMovie(movie);
            }
        });
    }
}
