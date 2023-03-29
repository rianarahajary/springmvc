package org.naina.film.model;

public class Film {
    int idFilm;
    String titre;

    public Film(){};
    public Film(int idFilm, String titre) {
        this.idFilm = idFilm;
        this.titre = titre;
    }
    public Film(String titre){
        this.titre = titre;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
