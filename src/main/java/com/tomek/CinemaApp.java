package com.tomek;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;
import com.tomek.view.MainFrame;

import javax.swing.*;
import java.sql.Date;

public class CinemaApp extends JFrame {
    public static void main(String[] args) {
        MovieDAO movieDAO = new MovieDAO();

        movieDAO.saveMovie(new Movie("Amadeusz", Date.valueOf("1984-09-06"), 160, "Milos Forman"));
//        movieDAO.saveMovie(new Movie("Rambo: Pierwsza Krew", Date.valueOf("1982-10-22"), 93, "Ted Kotcheff"));
//        movieDAO.saveMovie(new Movie("Ukryty wymiar", Date.valueOf("1997-11-21"), 95, "Paul W.S. Anderson"));
//
//        Movie firstMovie = movieDAO.getMovie(2);
//        firstMovie.setTitle("Rambo 2");
//        movieDAO.updateMovie(firstMovie);
//
//        ScreeningDAO screeningDAO = new ScreeningDAO();
//        List<Screening> screenings = new ArrayList<Screening>();
//
//        Screening screening1 = new Screening("2017-09-30 18:00:00");
//        screeningDAO.saveScreening(screening1);
//        screenings.add(screening1);
//
//        Screening screening2 = new Screening("2017-09-30 21:00:00");
//        screeningDAO.saveScreening(screening2);
//        screenings.add(screening2);
//
//        firstMovie.setScreenings(screenings);
//
//        movieDAO.updateMovie(firstMovie);



        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
            }
        });

        //HibernateUtil.getSessionFactory().close();
    }
}
