package org.naina.film.service;

import org.naina.film.dao.SceneDAO;
import org.naina.film.model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class SceneService {
    @Autowired
    SceneDAO sceneDAO;

    @Autowired
    DataSource dataSource;

    public void insert(Scene scene) throws SQLException {
        this.sceneDAO.setDataSource(this.dataSource);
        this.sceneDAO.insert(scene);
    }
    public int getLastId() throws SQLException{
        this.sceneDAO.setDataSource(this.dataSource);
        return this.sceneDAO.getLastId();
    }
    public List<Scene> getScenesByFilm(int idFilm) throws SQLException{
        this.sceneDAO.setDataSource(this.dataSource);
        return this.sceneDAO.getScenesByFilm(idFilm);
    }
    public void update(Scene scene) throws SQLException {
        this.sceneDAO.setDataSource(this.dataSource);
        this.sceneDAO.update(scene);
    }
    public void delete(int idScene) throws SQLException {
        this.sceneDAO.setDataSource(this.dataSource);
        this.sceneDAO.delete(idScene);
    }

    public Scene getSceneById(int idScene) throws SQLException {
        this.sceneDAO.setDataSource(this.dataSource);
        return this.sceneDAO.getSceneById(idScene);
    }



}
