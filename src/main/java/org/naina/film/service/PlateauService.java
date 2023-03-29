package org.naina.film.service;

import org.naina.film.dao.PlateauDAO;
import org.naina.film.model.Acteur;
import org.naina.film.model.Plateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class PlateauService {
    @Autowired
    PlateauDAO plateauDAO;

    @Autowired
    DataSource dataSource;

    public List<Plateau> getPlateaux() throws SQLException {
        this.plateauDAO.setDataSource(this.dataSource);
        List<Plateau> listePlateaux = this.plateauDAO.getPlateaux();
        return listePlateaux;
    }
    public void insert(Plateau plateau) throws SQLException{
        this.plateauDAO.insert(plateau);
    }
    public String getNomPlateau(int idPlateau) throws SQLException{
        this.plateauDAO.setDataSource(this.dataSource);
        return this.plateauDAO.getNomPlateau(idPlateau);
    }
    public void update(Plateau plateau) throws SQLException{
        this.plateauDAO.setDataSource(this.dataSource);
        this.plateauDAO.update(plateau);
    }
    public void delete(int idPlateau) throws SQLException{
        this.plateauDAO.setDataSource(this.dataSource);
        this.plateauDAO.delete(idPlateau);
    }
}
