package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<resultadoType> resultado;
        List<pronosticoType> pronostico;
        int puntaje = 0;
        lectorArchivo datosPartidos = new lectorArchivo("pronostico.csv", "resultados.csv");
        resultado = datosPartidos.getResultado();
        pronostico = datosPartidos.getPronostico();
        if (pronostico.size() != resultado.size()) throw new Exception("verifice si los archivos son los correctos");
        for (int i = 0; i < pronostico.size(); i++) {
            pronosticoType p = pronostico.get(i);
            resultadoType r = resultado.get(i);
            if (p.empate.equals("X")) {
                if (r.equipo1_goles == r.equipo2_goles) puntaje++;
                continue;
            }
            if (p.equipo1_gana.equals("X")) {
                if (r.equipo1_goles > r.equipo2_goles) puntaje++;
                continue;
            }
            if (p.equipo2_gana.equals("X")) {
                if (r.equipo1_goles < r.equipo2_goles) puntaje++;
            }
        }
System.out.println("El puntaje total es de "+puntaje);
    }
}