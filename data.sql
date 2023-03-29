-- acteurs
INSERT INTO acteurs VALUES (null,"Riana");
INSERT INTO acteurs VALUES (null,"Paul");

-- plateaux
INSERT INTO plateaux VALUES (null,"Plage");
INSERT INTO plateaux_detail VALUES (null,1,"Lundi",TIME('08:30:00'),TIME('09:30:00'));

-- scenes
INSERT INTO scenes VALUES (null,"Competition de natation",1);
INSERT INTO scenes_detail VALUES(null,1,1);

-- planning

INSERT INTO planning VALUES(null,"Tournage 1",1,4,DATE('2023-03-14'));