package com.tomek;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;
import java.sql.Date;

public class CinemaApp {
    public static void main(String[] args) {
        MovieDAO movieDAO = new MovieDAO();

        movieDAO.saveMovie(new Movie("Amadeusz", Date.valueOf("1984-09-06"), 160, "Milos Forman"));
        movieDAO.saveMovie(new Movie("Rambo: Pierwsza Krew", Date.valueOf("1982-10-22"), 93, "Ted Kotcheff"));
        movieDAO.saveMovie(new Movie("Ukryty wymiar", Date.valueOf("1997-11-21"), 95, "Paul W.S. Anderson"));

        Movie firstMovie = movieDAO.getMovie(2);
        firstMovie.setTitle("Rambo 2");
        movieDAO.updateMovie(firstMovie);

        Movie secondMovie = movieDAO.getMovie(3);
        movieDAO.removeMovie(secondMovie);

        HibernateUtil.getSessionFactory().close();
    }
}
