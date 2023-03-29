package org.naina.film.service;

import org.naina.film.dao.IndispoPlateauDAO;
import org.naina.film.model.IndispoPlateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class IndispoPlateauService {
    @Autowired
    DataSource dataSource;

    @Autowired
    IndispoPlateauDAO indispoPlateauDAO;

    public List<IndispoPlateau> getIndispoPlateaux() throws SQLException {
        this.indispoPlateauDAO.setDataSource(this.dataSource);
        List<IndispoPlateau> listeIndispoPlateau = this.indispoPlateauDAO.getIndispoPlateaux();
        return listeIndispoPlateau;
    }
    public void insert(IndispoPlateau indispoPlateau) throws SQLException{
        this.indispoPlateauDAO.setDataSource(this.dataSource);
        this.indispoPlateauDAO.insert(indispoPlateau);
    }
    public boolean isDispo(int idPlateau, LocalDate debut, LocalDate fin) throws SQLException{
        this.indispoPlateauDAO.setDataSource(this.dataSource);
        return this.indispoPlateauDAO.isDispo(idPlateau,debut,fin);
    }
    public void delete(int idIndispoPlateau) throws SQLException{
        this.indispoPlateauDAO.setDataSource(this.dataSource);
        this.indispoPlateauDAO.delete(idIndispoPlateau);
    }
}
