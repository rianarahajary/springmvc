CREATE DATABASE film;
use film;

CREATE TABLE films(
    idFilm INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(50)
);

CREATE TABLE acteurs (
    idActeur INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(15)
);
CREATE TABLE indispo_acteurs(
   idIndispoActeur INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   idActeur INT NOT NULL,
   dateIndispo date,
   heureDeb time,
   heureFin time,

   FOREIGN KEY (idActeur) REFERENCES acteurs(idActeur)
);
CREATE TABLE locations(
    idLocation INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(30),
    location INT NOT NULL
);
CREATE TABLE plateaux (
    idPlateau INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
    nom VARCHAR(15),
    idLocation INT,

    FOREIGN KEY (idLocation) REFERENCES locations(idLocation)
);
CREATE TABLE indispo_plateaux(
    idIndispoPlateau INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idPlateau INT NOT NULL,
    dateIndispo date,
    heureDeb time,
    heureFin time,

    FOREIGN KEY (idPlateau) REFERENCES plateaux(idPlateau)
);

CREATE TABLE scenes (
  idScene INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  idFilm INT NOT NULL,
  nom VARCHAR(50),
  idPlateau INT NOT NULL,
  heureFavorable TIME,
  duree INT,
  status VARCHAR (30) default "created",

  FOREIGN KEY (idFilm) REFERENCES films(idFilm),
  FOREIGN KEY (idPlateau) REFERENCES plateaux(idPlateau)
);

CREATE TABLE scene_acteur(
    idSceneActeur INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idScene INT NOT NULL,
    idActeur INT NOT NULL,

    FOREIGN KEY (idActeur) REFERENCES acteurs(idActeur)
);

CREATE TABLE suggestions(
  idSuggestion INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  idScene INT NOT NULL,
  debutTournage date,
  finTournage date,
  status VARCHAR(30)
);

