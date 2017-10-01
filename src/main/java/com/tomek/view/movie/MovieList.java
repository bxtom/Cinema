package com.tomek.view.movie;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;
import com.tomek.util.PanelsManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MovieList extends JPanel {

    private JList listMovies;
    private JButton btnDetails;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnRemove;

    public MovieList() {
        super();
        listMovies = new JList();
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDetails = new JButton("Details");
        btnRemove = new JButton("Remove");
        initView();
    }

    public void setMoviesList(List<Movie> list) {

        DefaultListModel<Movie> listModel = new DefaultListModel<>();

        for (Movie movie : list) {
            listModel.addElement(movie);
        }

        listMovies = new JList<>(listModel);
    }

    private void initView() {
        setLayout(new MigLayout("nogrid"));

        MovieDAO movieDAO = new MovieDAO();
        List<Movie> list = movieDAO.getMovieList();

        DefaultListModel<Movie> listModel = new DefaultListModel<>();

        for (Movie movie : list) {
            listModel.addElement(movie);
        }

        listMovies = new JList<>(listModel);
        listMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listMovies.setMinimumSize(new Dimension(400, 500));

        btnAdd.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            PanelsManager.changePanel(frame, new MovieAdd());
        });

        btnDetails.addActionListener(e -> {
            if (!listMovies.isSelectionEmpty()) {
                Movie movie = (Movie) listMovies.getSelectedValue();

                MovieDetails details = new MovieDetails();
                details.setMovieTitle(movie.getTitle());
                details.setMovieDirector(movie.getDirector());
                details.setMovieDuration("" + movie.getDuration());
                details.setMovieYear("" + movie.getYear());

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                PanelsManager.changePanel(frame, details);
            }
        });

        btnUpdate.addActionListener(e -> {
            if (!listMovies.isSelectionEmpty()) {
                Movie movie = (Movie) listMovies.getSelectedValue();

                MovieUpdate update = new MovieUpdate(movie);
                update.setTitle(movie.getTitle());
                update.setDirector(movie.getDirector());
                update.setDuration("" + movie.getDuration());

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                PanelsManager.changePanel(frame, update);
            }
        });

        btnRemove.addActionListener(e -> {
            if (!listMovies.isSelectionEmpty()) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null,
                        "Are you sure?",
                        "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    Movie movie = (Movie) listMovies.getSelectedValue();
                    MovieDAO dao = new MovieDAO();
                    dao.removeMovie(movie);

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    PanelsManager.changePanel(frame, new MovieList());
                }
            }
        });

        add(listMovies, "wrap");
        add(btnAdd, "split 3");
        add(btnUpdate, "");
        add(btnDetails, "");
        add(btnRemove);
    }
}
