package org.naina.film.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class Plateau {
    int idPlateau;
    String nom;
    int idLocation;

    public Plateau(){};
    public Plateau(int idPlateau, String nom) {
        this.idPlateau = idPlateau;
        this.nom = nom;
    }
    public Plateau(String nom) {
        this.nom = nom;
    }

    public Plateau(int idPlateau, String nom, int idLocation) {
        this.idPlateau = idPlateau;
        this.nom = nom;
        this.idLocation = idLocation;
    }

    public int getIdPlateau() {
        return idPlateau;
    }

    public void setIdPlateau(int idPlateau) {
        this.idPlateau = idPlateau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }
}
