package org.naina.film.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class IndispoPlateau {
    int idIndispoPlateau;
    int idPlateau;
    LocalDate date;
    LocalTime heureDebut;
    LocalTime heureFin;

    public IndispoPlateau() {}

    public IndispoPlateau(int idPlateau, LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
        this.idPlateau = idPlateau;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public IndispoPlateau(int idIndispoPlateau, int idPlateau, LocalDate date, LocalTime heureDebut, LocalTime heureFin) {
        this.idIndispoPlateau = idIndispoPlateau;
        this.idPlateau = idPlateau;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public int getIdIndispoPlateau() {
        return idIndispoPlateau;
    }

    public void setIdIndispoPlateau(int idIndispoPlateau) {
        this.idIndispoPlateau = idIndispoPlateau;
    }

    public int getIdPlateau() {
        return idPlateau;
    }

    public void setIdPlateau(int idPlateau) {
        this.idPlateau = idPlateau;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }
}
