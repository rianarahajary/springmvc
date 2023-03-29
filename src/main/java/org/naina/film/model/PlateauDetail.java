package org.naina.film.model;

import java.sql.Time;
import java.time.LocalDateTime;

public class PlateauDetail {
    int idPlateauDetail;
    int idPlateau;
    String dispoJour;
    Time dispoHeureDebut;
    Time dispoHeureFin;

    public PlateauDetail(){};

    public PlateauDetail(int idPlateauDetail, int idPlateau, String dispoJour, Time dispoHeureDebut, Time dispoHeureFin) {
        this.idPlateauDetail = idPlateauDetail;
        this.idPlateau = idPlateau;
        this.dispoJour = dispoJour;
        this.dispoHeureDebut = dispoHeureDebut;
        this.dispoHeureFin = dispoHeureFin;
    }

    public int getIdPlateauDetail() {
        return idPlateauDetail;
    }

    public void setIdPlateauDetail(int idPlateauDetail) {
        this.idPlateauDetail = idPlateauDetail;
    }

    public int getIdPlateau() {
        return idPlateau;
    }

    public void setIdPlateau(int idPlateau) {
        this.idPlateau = idPlateau;
    }

    public String getDispoJour() {
        return dispoJour;
    }

    public void setDispoJour(String dispoJour) {
        this.dispoJour = dispoJour;
    }

    public Time getDispoHeureDebut() {
        return dispoHeureDebut;
    }

    public void setDispoHeureDebut(Time dispoHeureDebut) {
        this.dispoHeureDebut = dispoHeureDebut;
    }

    public Time getDispoHeureFin() {
        return dispoHeureFin;
    }

    public void setDispoHeureFin(Time dispoHeureFin) {
        this.dispoHeureFin = dispoHeureFin;
    }
}
