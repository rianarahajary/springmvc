package org.naina.film.dao;

import org.naina.film.model.Acteur;
import org.naina.film.model.IndispoPlateau;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class IndispoPlateauDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<IndispoPlateau> getIndispoPlateaux() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<IndispoPlateau> indispoPlateaux = new ArrayList<IndispoPlateau>();
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM indispo_plateaux";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                IndispoPlateau indispoPlateau = new IndispoPlateau(
                        rs.getInt("idIndispoPlateau"),
                        rs.getInt("idPlateau"),
                        rs.getDate("dateIndispo").toLocalDate(),
                        rs.getTime("heureDeb").toLocalTime(),
                        rs.getTime("heureFin").toLocalTime()
                );
                indispoPlateaux.add(indispoPlateau);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return indispoPlateaux;
    }
    public void insert(IndispoPlateau indispoPlateau) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO indispo_plateaux VALUES (null,?,?,?,?)");
            pstmt.setInt(1, indispoPlateau.getIdPlateau());
            pstmt.setDate(2,Date.valueOf(indispoPlateau.getDate()));
            pstmt.setTime(3,Time.valueOf(indispoPlateau.getHeureDebut()));
            pstmt.setTime(4,Time.valueOf(indispoPlateau.getHeureFin()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public boolean isDispo(int idPlateau, LocalDate debut, LocalDate fin) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM indispo_plateaux WHERE dateIndispo BETWEEN ? AND ? AND idPlateau = ?")) {
            stmt.setDate(1, Date.valueOf(debut));
            stmt.setDate(2, Date.valueOf(fin));
            stmt.setInt(3,idPlateau);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) == 0;
            }
        }
    }
    public void delete(int idIndispoPlateau) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("DELETE from indispo_plateaux where idIndispoPlateau = ?");
            pstmt.setInt(1, idIndispoPlateau);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
