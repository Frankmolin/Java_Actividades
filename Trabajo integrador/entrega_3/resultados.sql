CREATE TABLE resultados(
   Partido_id              INTEGER  NOT NULL PRIMARY KEY 
  ,Fase_nro                INTEGER  NOT NULL
  ,Ronda_nro               INTEGER  NOT NULL
  ,Equipo_1_id             INTEGER  NOT NULL
  ,Equipo_1_nombre         VARCHAR(40) NOT NULL
  ,Equipo_1_descripcion    VARCHAR(40) NOT NULL
  ,Equipo_1_cantidad_goles INTEGER  NOT NULL
  ,Equipo_2_cantidad_goles INTEGER  NOT NULL
  ,Equipo_2_id             INTEGER  NOT NULL
  ,Equipo_2_nombre         VARCHAR(40) NOT NULL
  ,Equipo_2_descripcion    VARCHAR(40) NOT NULL
);
INSERT INTO resultados(Partido_id,Fase_nro,Ronda_nro,Equipo_1_id,Equipo_1_nombre,Equipo_1_descripcion,Equipo_1_cantidad_goles,Equipo_2_cantidad_goles,Equipo_2_id,Equipo_2_nombre,Equipo_2_descripcion) VALUES (0,1,1,1,'Argentina','Seleccionado',1,2,2,'Arabia Saudita','Seleccionado');
INSERT INTO resultados(Partido_id,Fase_nro,Ronda_nro,Equipo_1_id,Equipo_1_nombre,Equipo_1_descripcion,Equipo_1_cantidad_goles,Equipo_2_cantidad_goles,Equipo_2_id,Equipo_2_nombre,Equipo_2_descripcion) VALUES (1,1,1,3,'Polonia','Seleccionado',0,0,4,'México','Seleccionado');
INSERT INTO resultados(Partido_id,Fase_nro,Ronda_nro,Equipo_1_id,Equipo_1_nombre,Equipo_1_descripcion,Equipo_1_cantidad_goles,Equipo_2_cantidad_goles,Equipo_2_id,Equipo_2_nombre,Equipo_2_descripcion) VALUES (2,1,1,1,'Argentina','Seleccionado',2,0,4,'México','Seleccionado');
INSERT INTO resultados(Partido_id,Fase_nro,Ronda_nro,Equipo_1_id,Equipo_1_nombre,Equipo_1_descripcion,Equipo_1_cantidad_goles,Equipo_2_cantidad_goles,Equipo_2_id,Equipo_2_nombre,Equipo_2_descripcion) VALUES (3,1,1,2,'Arabia Saudita','Seleccionado',0,2,3,'Polonia','Seleccionado');
INSERT INTO resultados(Partido_id,Fase_nro,Ronda_nro,Equipo_1_id,Equipo_1_nombre,Equipo_1_descripcion,Equipo_1_cantidad_goles,Equipo_2_cantidad_goles,Equipo_2_id,Equipo_2_nombre,Equipo_2_descripcion) VALUES (4,1,2,3,'Polonia','Seleccionado',0,3,1,'Argentina','Seleccionado');
