package org.example;

public class Ronda {
    private int idPartido;
    private int nroFase;
    private int nroRonda;
    private int idEquipo1;
    private String nombreEquipo1;
    private String descripcionEquipo1;
    private int cantidadGolesEquipo1;
    private int cantidadGolesEquipo2;
    private int idEquipo2;
    private String nombreEquipo2;
    private String descripcionEquipo2;

    public Ronda(int idPartido,int nroFase, int nroRonda, int idEquipo1, String nombreEquipo1, String descripcionEquipo1,
                 int cantidadGolesEquipo1, int cantidadGolesEquipo2, int idEquipo2, String nombreEquipo2,
                 String descripcionEquipo2) {
        this.idPartido = idPartido;
        this.nroFase=nroFase;
        this.nroRonda = nroRonda;
        this.idEquipo1 = idEquipo1;
        this.nombreEquipo1 = nombreEquipo1;
        this.descripcionEquipo1 = descripcionEquipo1;
        this.cantidadGolesEquipo1 = cantidadGolesEquipo1;
        this.cantidadGolesEquipo2 = cantidadGolesEquipo2;
        this.idEquipo2 = idEquipo2;
        this.nombreEquipo2 = nombreEquipo2;
        this.descripcionEquipo2 = descripcionEquipo2;
    }

    public int getIdPartido() {
        return idPartido;
    }
    public int getNroFase() {
        return nroFase;
    }

    public int getNroRonda() {
        return nroRonda;
    }

    public int getIdEquipo1() {
        return idEquipo1;
    }

    public String getNombreEquipo1() {
        return nombreEquipo1;
    }

    public String getDescripcionEquipo1() {
        return descripcionEquipo1;
    }

    public int getCantidadGolesEquipo1() {
        return cantidadGolesEquipo1;
    }

    public int getCantidadGolesEquipo2() {
        return cantidadGolesEquipo2;
    }

    public int getIdEquipo2() {
        return idEquipo2;
    }

    public String getNombreEquipo2() {
        return nombreEquipo2;
    }

    public String getDescripcionEquipo2() {
        return descripcionEquipo2;
    }
    public boolean getGana_1() {
        return cantidadGolesEquipo1>cantidadGolesEquipo2;
    }

    public boolean getEmpata() {
        return cantidadGolesEquipo1==cantidadGolesEquipo2;
    }

    public boolean getGana_2() {
        return cantidadGolesEquipo1<cantidadGolesEquipo2;
    }
}
