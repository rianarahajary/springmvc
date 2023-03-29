package org.naina.film.model;

import java.time.LocalDate;

public class Suggestion {
    int idSuggestion;
    int idScene;
    LocalDate debutTournage;
    LocalDate finTournage ;
    String status;

    public Suggestion() {
    }

    public Suggestion(int idScene, LocalDate debutTournage, LocalDate finTournage, String status) {
        this.idScene = idScene;
        this.debutTournage = debutTournage;
        this.finTournage = finTournage;
        this.status = status;
    }
    public Suggestion(int idScene, LocalDate debutTournage, LocalDate finTournage) {
        this.idScene = idScene;
        this.debutTournage = debutTournage;
        this.finTournage = finTournage;
    }
    public Suggestion(int idSuggestion, int idScene, LocalDate debutTournage, LocalDate finTournage, String status) {
        this.idSuggestion = idSuggestion;
        this.idScene = idScene;
        this.debutTournage = debutTournage;
        this.finTournage = finTournage;
        this.status = status;
    }

    public int getIdSuggestion() {
        return idSuggestion;
    }

    public void setIdSuggestion(int idSuggestion) {
        this.idSuggestion = idSuggestion;
    }

    public int getIdScene() {
        return idScene;
    }

    public void setIdScene(int idScene) {
        this.idScene = idScene;
    }

    public LocalDate getDebutTournage() {
        return debutTournage;
    }

    public void setDebutTournage(LocalDate debutTournage) {
        this.debutTournage = debutTournage;
    }

    public LocalDate getFinTournage() {
        return finTournage;
    }

    public void setFinTournage(LocalDate finTournage) {
        this.finTournage = finTournage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
