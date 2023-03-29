package org.naina.film.dao;

import org.naina.film.model.Acteur;
import org.naina.film.model.Plateau;
import org.naina.film.model.Scene;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlateauDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Plateau> getPlateaux() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<Plateau> plateaux = new ArrayList<Plateau>();
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM plateaux";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Plateau plateau = new Plateau(
                        rs.getInt("idPlateau"),
                        rs.getString("nom")
                );
                plateaux.add(plateau);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return plateaux;
    }
    public void insert(Plateau plateau) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO plateaux VALUES (null,?,null)");
            pstmt.setString(1, plateau.getNom());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public String getNomPlateau(int idPlateau) throws SQLException {
        Connection connection = dataSource.getConnection();
        String valiny = "";
        try {
            String query = "SELECT nom FROM plateaux where idPlateau = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,idPlateau);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                valiny = rs.getString("nom");
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return valiny;
    }
    public void update(Plateau plateau) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("update plateaux set nom = ? where idPlateau = ?");
            pstmt.setString(1, plateau.getNom());
            pstmt.setInt(2,plateau.getIdPlateau());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public void delete(int idPlateau) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("delete from plateaux where idPlateau = ?");
            pstmt.setInt(1,idPlateau);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
