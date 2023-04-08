package org.example;

import com.opencsv.bean.CsvBindByPosition;

public class pronosticoType {
    @CsvBindByPosition(position = 0)
     int equipo1_id;
    @CsvBindByPosition(position = 1)
     String equipo1_gana;
    @CsvBindByPosition(position = 2)
     String empate;
    @CsvBindByPosition(position = 3)
     String equipo2_gana;
    @CsvBindByPosition(position = 4)
     int equipo2_id;



}


