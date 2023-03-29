package org.naina.film.service;

import org.naina.film.dao.SceneActeurDAO;
import org.naina.film.model.Acteur;
import org.naina.film.model.SceneActeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class SceneActeurService {
    @Autowired
    SceneActeurDAO sceneActeurDAO;

    @Autowired
    DataSource dataSource;

    public void insert(SceneActeur sceneActeur) throws SQLException {
        this.sceneActeurDAO.setDataSource(this.dataSource);
        this.sceneActeurDAO.insert(sceneActeur);
    }
    public List<SceneActeur> getSceneActeur() throws SQLException{
        this.sceneActeurDAO.setDataSource(this.dataSource);
        return sceneActeurDAO.getSceneActeur();
    }
    public List<SceneActeur> getActeursByScene(int idScene) throws SQLException{
        this.sceneActeurDAO.setDataSource(this.dataSource);
        return sceneActeurDAO.getActeursByScene(idScene);
    }
}
