package org.example;

import java.util.stream.DoubleStream;

public class Participante {
    private int participante_id;
    private String participante_nombre;
    private int partido_id;
    private int equipo_1_id;
    private boolean gana_1;
    private boolean empata;
    private boolean gana_2;
    private int equipo_2_id;

    public Participante(int participante_id, String participante_nombre,int partido_id, int equipo_1_id, boolean gana_1, boolean empata, boolean gana_2, int equipo_2_id) {
        this.participante_id = participante_id;
        this.participante_nombre = participante_nombre;
        this.partido_id=partido_id;
        this.equipo_1_id = equipo_1_id;
        this.gana_1 = gana_1;
        this.empata = empata;
        this.gana_2 = gana_2;
        this.equipo_2_id = equipo_2_id;
    }

    public int getParticipante_id() {
        return participante_id;
    }

    public String getParticipante_nombre() {
        return participante_nombre;
    }
    public int getPartido_id() {
        return partido_id;
    }

    public int getEquipo_1_id() {
        return equipo_1_id;
    }

    public boolean getGana_1() {
        return gana_1;
    }

    public boolean getEmpata() {
        return empata;
    }

    public boolean getGana_2() {
        return gana_2;
    }

    public int getEquipo_2_id() {
        return equipo_2_id;
    }


}
