package org.naina.film.dao;

import org.naina.film.model.Acteur;
import org.naina.film.model.Film;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilmDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Film> getFilms() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<Film> films = new ArrayList<Film>();
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM films";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Film film = new Film(
                        rs.getInt("idFilm"),
                        rs.getString("titre")
                );
                films.add(film);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return films;
    }

    public void insert(Film film) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO films VALUES (null,?)");
            pstmt.setString(1, film.getTitre());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
