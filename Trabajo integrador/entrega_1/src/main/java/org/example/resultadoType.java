package org.example;

import com.opencsv.bean.CsvBindByPosition;

public class resultadoType {
    @CsvBindByPosition(position = 0)
    int equipo1_id;
    @CsvBindByPosition(position = 1)
     String equipo1_nombre;
    @CsvBindByPosition(position = 2)
     String equipo1_descripcion;
    @CsvBindByPosition(position = 3)
     int equipo1_goles;
    @CsvBindByPosition(position = 4)
     int equipo2_goles;
    @CsvBindByPosition(position = 5)
     int equipo2_id;
    @CsvBindByPosition(position = 6)
     String equipo2_nombre;
    @CsvBindByPosition(position =7)
     String equipo2_descripcion;

}
