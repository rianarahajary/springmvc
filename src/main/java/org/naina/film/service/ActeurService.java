package org.naina.film.service;

import org.naina.film.dao.ActeurDAO;
import org.naina.film.model.Acteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class ActeurService {
    @Autowired
    ActeurDAO acteurDAO;

    @Autowired
    DataSource dataSource;

    public List<Acteur> getActeurs() throws SQLException {
        this.acteurDAO.setDataSource(this.dataSource);
        return this.acteurDAO.getActeurs();
    }
    public void insert(Acteur acteur) throws SQLException{
        this.acteurDAO.setDataSource(this.dataSource);
        this.acteurDAO.insert(acteur);
    }
    public void delete(Acteur acteur) throws SQLException{
        this.acteurDAO.setDataSource(this.dataSource);
        this.acteurDAO.delete(acteur);
    }
    public void update(Acteur acteur) throws SQLException{
        this.acteurDAO.setDataSource(this.dataSource);
        this.acteurDAO.update(acteur);
    }

    public Acteur getActeurById(int idActeur) throws SQLException{
        this.acteurDAO.setDataSource(this.dataSource);
        return this.acteurDAO.getActeurById(idActeur);
    }

}
