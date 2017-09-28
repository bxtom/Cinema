package com.tomek;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;
import java.sql.Date;

public class CinemaApp {
    public static void main(String[] args) {
        MovieDAO movieDAO = new MovieDAO();

        Movie amadeusz = new Movie();
        amadeusz.setTitle("Amadeusz");
        amadeusz.setDuration(160);
        amadeusz.setYear(Date.valueOf("1984-09-06"));
        amadeusz.setDirector("Milos Forman");
        movieDAO.addMovie(amadeusz);

        Movie rambo = new Movie();
        rambo.setTitle("Rambo: Pierwsza Krew");
        rambo.setDuration(93);
        rambo.setYear(Date.valueOf("1982-10-22"));
        rambo.setDirector("Ted Kotcheff");
        movieDAO.addMovie(rambo);

        Movie ukrytyWymiar = new Movie();
        ukrytyWymiar.setTitle("Ukryty wymiar");
        ukrytyWymiar.setDuration(95);
        ukrytyWymiar.setYear(Date.valueOf("1997-11-21"));
        ukrytyWymiar.setDirector("Paul W.S. Anderson");
        movieDAO.addMovie(ukrytyWymiar);

        Movie firstMovie = movieDAO.getMovie(1);

        System.out.println(firstMovie);

        HibernateUtil.getSessionFactory().close();
    }
}
