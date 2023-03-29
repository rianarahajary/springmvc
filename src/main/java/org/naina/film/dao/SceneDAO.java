package org.naina.film.dao;

import org.naina.film.model.Acteur;
import org.naina.film.model.Scene;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SceneDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Scene scene) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO scenes VALUES (null,?,?,?,?,?,?)");
            pstmt.setInt(1,scene.getIdFilm());
            pstmt.setString(2, scene.getNom());
            pstmt.setInt(3, scene.getIdPlateau());
            pstmt.setTime(4,Time.valueOf(scene.getHeureFav()));
            pstmt.setInt(5,scene.getDuree());
            pstmt.setString(6,"Creee");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public int getLastId() throws SQLException {
        int lastId = 0;
        try (Connection connection = dataSource.getConnection()){
            Statement stmt = connection.createStatement();
            String query = "select * from scenes order by idScene desc limit 1;";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                lastId = rs.getInt("idScene");
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return lastId;
    }
    public List<Scene> getScenesByFilm(int idFilm) throws SQLException {
        Connection connection = dataSource.getConnection();
        List<Scene> scenes = new ArrayList<Scene>();
        try {
            String query = "SELECT * FROM scenes where idFilm = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,idFilm);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Scene scene = new Scene(
                        rs.getInt("idScene"),
                        rs.getInt("idFilm"),
                        rs.getInt("idPlateau"),
                        rs.getString("nom"),
                        rs.getTime("heureFavorable").toLocalTime(),
                        rs.getInt("duree"),
                        rs.getString("status")
                );
                scenes.add(scene);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return scenes;
    }

    public Scene getSceneById(int idScene) throws SQLException {
        Connection connection = dataSource.getConnection();
        Scene scene = null;
        try {
            String query = "SELECT * FROM scenes where idScene = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,idScene);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                 scene = new Scene(
                        rs.getInt("idScene"),
                        rs.getInt("idFilm"),
                        rs.getInt("idPlateau"),
                        rs.getString("nom"),
                        rs.getTime("heureFavorable").toLocalTime(),
                        rs.getInt("duree"),
                        rs.getString("status")
                );
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return scene;
    }

    public void update(Scene scene) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("UPDATE scenes SET " +
                    "nom = ?, idPlateau = ?, heureFavorable = ?, duree = ?, status = ? WHERE idScene = ?");
            pstmt.setString(1, scene.getNom());
            pstmt.setInt(2, scene.getIdPlateau());
            pstmt.setTime(3,Time.valueOf(scene.getHeureFav()));
            pstmt.setInt(4,scene.getDuree());
            pstmt.setString(5,"Creee");
            pstmt.setInt(6,scene.getIdScene());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    public void delete(int idScene) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM scene_acteur WHERE idScene = ?");
            pstmt.setInt(1, idScene);
            pstmt.executeUpdate();

            pstmt = connection.prepareStatement("DELETE FROM scenes WHERE idScene = ?");
            pstmt.setInt(1, idScene);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
