package org.naina.film.dao;

import org.naina.film.model.Acteur;
import org.naina.film.model.Scene;
import org.naina.film.model.SceneActeur;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SceneActeurDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(SceneActeur sceneActeur) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO scene_acteur VALUES (null,?, ?)");
            pstmt.setInt(1, sceneActeur.getIdScene());
            pstmt.setInt(2, sceneActeur.getIdActeur());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public List<SceneActeur> getSceneActeur() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<SceneActeur> listeSceneActeur = new ArrayList<SceneActeur>();
        try {
            String query = "select * from scene_acteur";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SceneActeur sceneActeur = new SceneActeur(
                        rs.getInt("idSceneActeur"),
                        rs.getInt("idScene"),
                        rs.getInt("idActeur")
                );
                listeSceneActeur.add(sceneActeur);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return listeSceneActeur;
    }
    public List<SceneActeur> getActeursByScene(int idScene) throws SQLException {
        Connection connection = dataSource.getConnection();
        List<SceneActeur> listeSceneActeur = new ArrayList<SceneActeur>();
        try {
            String query = "SELECT * FROM scene_acteur where idScene = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,idScene);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SceneActeur sceneActeur = new SceneActeur(
                        rs.getInt("idSceneActeur"),
                        rs.getInt("idScene"),
                        rs.getInt("idActeur")
                );
                listeSceneActeur.add(sceneActeur);
            }
            rs.close();
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return listeSceneActeur;
    }
}
