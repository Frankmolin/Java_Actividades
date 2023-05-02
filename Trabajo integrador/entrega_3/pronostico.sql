CREATE TABLE pronostico(
   Participante_id     INTEGER  NOT NULL PRIMARY KEY 
  ,Participante_nombre VARCHAR(40) NOT NULL
  ,Partido_id          INTEGER  NOT NULL
  ,Equipo_1_id         INTEGER  NOT NULL
  ,Gana_1              VARCHAR
  ,Empata              VARCHAR
  ,Gana_2              VARCHAR
  ,Equipo_2_id         INTEGER  NOT NULL
);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mariana',0,1,'X',NULL,NULL,2);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mariana',1,3,NULL,'X',NULL,4);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mariana',2,1,'X',NULL,NULL,4);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mariana',3,2,NULL,NULL,'X',3);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (2,'Pedro',0,1,'X',NULL,NULL,2);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (2,'Pedro',1,3,NULL,NULL,'X',4);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (2,'Pedro',2,1,'X',NULL,NULL,4);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (2,'Pedro',3,2,NULL,'X',NULL,3);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mariana',4,3,'X',NULL,NULL,1);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mari',0,1,NULL,NULL,'X',2);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mari',1,3,NULL,'X',NULL,4);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mari',2,1,'X',NULL,NULL,4);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mari',3,2,NULL,NULL,'X',3);
INSERT INTO pronostico(Participante_id,Participante_nombre,Partido_id,Equipo_1_id,Gana_1,Empata,Gana_2,Equipo_2_id) VALUES (1,'Mari',4,3,NULL,NULL,'X',1);
