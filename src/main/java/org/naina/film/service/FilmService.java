package org.naina.film.service;

import org.naina.film.dao.FilmDAO;
import org.naina.film.model.Acteur;
import org.naina.film.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmDAO filmDAO;

    @Autowired
    DataSource dataSource;

    public List<Film> getFilms() throws SQLException {
        this.filmDAO.setDataSource(this.dataSource);
        List<Film> listeFilm = this.filmDAO.getFilms();
        return listeFilm;
    }
    public void insert(Film film) throws SQLException{
        this.filmDAO.insert(film);
    }
}
