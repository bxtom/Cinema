package com.tomek.view.movie;

import com.tomek.entity.Movie;
import com.tomek.entity.dao.MovieDAO;
import com.tomek.presenter.MoviePresenter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MovieListView extends JPanel {

    private JList listMovies;

    public MovieListView() {
        init();
    }

    private void setMoviesList(List<Movie> list) {
        DefaultListModel<Movie> listModel = new DefaultListModel<>();

        for (Movie movie : list) {
            listModel.addElement(movie);
        }

        listMovies = new JList<>(listModel);
    }

    private void init() {
        setLayout(new MigLayout("nogrid"));

        listMovies = new JList();
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDetails = new JButton("Details");
        JButton btnRemove = new JButton("Remove");

        MovieDAO movieDAO = new MovieDAO();
        setMoviesList(movieDAO.getMovieList());

        listMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listMovies.setMinimumSize(new Dimension(400, 200));


        add(listMovies, "wrap");
        add(btnAdd, "split 3");
        add(btnUpdate, "");
        add(btnDetails, "");
        add(btnRemove);

        btnAdd.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            MoviePresenter presenter = new MoviePresenter();
            presenter.setFrame(frame);
            presenter.showMovieAddView();
        });

        btnDetails.addActionListener(e -> {
            if (!listMovies.isSelectionEmpty()) {
                Movie movie = (Movie) listMovies.getSelectedValue();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

                MoviePresenter presenter = new MoviePresenter();
                presenter.setFrame(frame);
                presenter.showMovieDetailsView(movie);
            }
        });

        btnUpdate.addActionListener(e -> {
            if (!listMovies.isSelectionEmpty()) {
                Movie movie = (Movie) listMovies.getSelectedValue();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

                MoviePresenter presenter = new MoviePresenter();
                presenter.setFrame(frame);
                presenter.showMovieUpdateView(movie);
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

                    MoviePresenter presenter = new MoviePresenter();
                    presenter.removeMovie(movie);

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

                    presenter.setFrame(frame);
                    presenter.showListOfMoviesView();
                }
            }
        });
    }
}
