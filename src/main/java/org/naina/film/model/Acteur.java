package org.naina.film.model;

public class Acteur {
    int idActeur;
    String nom;
    public Acteur(){}

    public Acteur(int idActeur, String nom) {
        this.idActeur = idActeur;
        this.nom = nom;
    }
    public Acteur(String nom) {
        this.nom = nom;
    }

    public int getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(int idActeur) {
        this.idActeur = idActeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
