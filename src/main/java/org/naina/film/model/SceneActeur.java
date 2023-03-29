package org.naina.film.model;

public class SceneActeur {
    int idSceneActeur;
    int idScene;
    int idActeur;

    public SceneActeur(){}

    public SceneActeur(int idSceneActeur, int idScene, int idActeur) {
        this.idSceneActeur = idSceneActeur;
        this.idScene = idScene;
        this.idActeur = idActeur;
    }

    public SceneActeur(int idScene, int idActeur) {
        this.idScene = idScene;
        this.idActeur = idActeur;
    }

    public int getIdSceneActeur() {
        return idSceneActeur;
    }

    public void setIdSceneActeur(int idSceneActeur) {
        this.idSceneActeur = idSceneActeur;
    }

    public int getIdScene() {
        return idScene;
    }

    public void setIdScene(int idScene) {
        this.idScene = idScene;
    }

    public int getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(int idActeur) {
        this.idActeur = idActeur;
    }
}
