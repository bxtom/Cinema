package com.tomek;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CinemaAppFrame extends JFrame {
    public CinemaAppFrame() {
        init();
    }

    private void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinema");
        setSize(700, 500);
        setVisible(true);

        JLabel labTitle = new JLabel("Title");
        JTextField tfTtitle = new JTextField();

        JLabel labDuration = new JLabel("Duration");
        JTextField tfDuration = new JTextField();

        JLabel labDate = new JLabel("Date");
        JTextField tfDate = new JTextField();

        JLabel labDirector = new JLabel("Director");
        JTextField tfDirector = new JTextField();


        JButton bSave = new JButton("Save");
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Movie movie = new Movie();
                movie.setTitle(tfTtitle.getText());
                movie.setDuration(Integer.valueOf(tfDuration.getText()));
                movie.setYear(Date.valueOf(tfDate.getText()));
                movie.setDirector(tfDirector.getText());

                MovieDAO dao = new MovieDAO();
                dao.saveMovie(movie);
            }
        });


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        getContentPane().add(labTitle);
        getContentPane().add(tfTtitle);
        getContentPane().add(labDuration);
        getContentPane().add(tfDuration);
        getContentPane().add(labDate);
        getContentPane().add(tfDate);
        getContentPane().add(labDirector);
        getContentPane().add(tfDirector);
        getContentPane().add(bSave);

    }

    private String czasW(ZoneId zoneId) {
        ZonedDateTime time = ZonedDateTime.now(zoneId);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return time.format(dateTimeFormatter);
    }
}
