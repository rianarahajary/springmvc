package org.naina.film.model;

import org.springframework.cglib.core.Local;

import java.sql.Time;
import java.time.LocalTime;

public class Scene {
    int idScene;
    int idFilm;
    int idPlateau;
    String nom;
    LocalTime heureFav;
    int duree;
    String status;
    public Scene(){};

    public Scene(int idScene, int idFilm, int idPlateau, String nom, LocalTime heureFav, int duree, String status) {
        this.idScene = idScene;
        this.idFilm = idFilm;
        this.idPlateau = idPlateau;
        this.nom = nom;
        this.heureFav = heureFav;
        this.duree = duree;
        this.status = status;
    }
    public Scene(int idFilm, int idPlateau, String nom, LocalTime heureFav, int duree) {
        this.idFilm = idFilm;
        this.idPlateau = idPlateau;
        this.nom = nom;
        this.heureFav = heureFav;
        this.duree = duree;
    }
    public Scene(int idFilm, int idPlateau, String nom, LocalTime heureFav, int duree, String status) {
        this.idFilm = idFilm;
        this.idPlateau = idPlateau;
        this.nom = nom;
        this.heureFav = heureFav;
        this.duree = duree;
        this.status = status;
    }

    public int getIdScene() {
        return idScene;
    }

    public void setIdScene(int idScene) {
        this.idScene = idScene;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
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

    public LocalTime getHeureFav() {
        return heureFav;
    }

    public void setHeureFav(LocalTime heureFav) {
        this.heureFav = heureFav;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
