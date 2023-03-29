package org.naina.film.dao;

import org.naina.film.model.Acteur;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ActeurDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Acteur> getActeurs() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<Acteur> acteurs = new ArrayList<Acteur>();
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM acteurs";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Acteur acteur = new Acteur(
                        rs.getInt("idActeur"),
                        rs.getString("nom")
                );
                acteurs.add(acteur);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return acteurs;
    }

    public Acteur getActeurById(int idActeur) throws SQLException {
        Connection connection = dataSource.getConnection();
        Acteur acteur = null;
        try {
            String query = "SELECT * FROM acteurs where idActeur = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,idActeur);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                acteur = new Acteur(
                        rs.getInt("idActeur"),
                        rs.getString("nom")
                );
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return acteur;
    }

    public void insert(Acteur acteur) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO acteurs VALUES (null,?)");
            pstmt.setString(1, acteur.getNom());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public void delete(Acteur acteur) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("DELETE from acteurs where idActeur = ?");
            pstmt.setInt(1, acteur.getIdActeur());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public void update(Acteur acteur) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("update acteurs set nom = ? where idActeur = ?");
            pstmt.setString(1, acteur.getNom());
            pstmt.setInt(2,acteur.getIdActeur());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
